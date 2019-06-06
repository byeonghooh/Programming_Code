# Author: Miguel Martinez Lopez
# Version: 0.14
import csv

try:
    from tkinter import Frame, Label, Message, StringVar
    from tkconstants import *
    from tkinter import csv
    import csv
except ImportError:
    from tkinter import Frame, Label, Message, StringVar
    from tkinter.constants import *


class Cell(Frame):
    """Base class for cells"""


class Data_Cell(Cell):
    def __init__(self, master, variable, anchor=W, bordercolor=None, borderwidth=1, padx=0, pady=0, background=None,
                 foreground=None, font=None):
        Cell.__init__(self, master, background=background, highlightbackground=bordercolor, highlightcolor=bordercolor,
                      highlightthickness=borderwidth, bd=0)

        self._message_widget = Message(self, textvariable=variable, font=font, background=background,
                                       foreground=foreground)
        self._message_widget.pack(expand=True, padx=padx, pady=pady, anchor=anchor)

        self.bind("<Configure>", self._on_configure)

    def _on_configure(self, event):
        self._message_widget.configure(width=event.width)


class Header_Cell(Cell):
    def __init__(self, master, text, bordercolor=None, borderwidth=1, padx=None, pady=None, background=None,
                 foreground=None, font=None, anchor=CENTER):
        Cell.__init__(self, master, background=background, highlightbackground=bordercolor, highlightcolor=bordercolor,
                      highlightthickness=borderwidth, bd=0)
        self._header_label = Label(self, text=text, background=background, foreground=foreground, font=font)
        self._header_label.pack(padx=padx, pady=pady, expand=True)

        if bordercolor is not None:
            separator = Frame(self, height=2, background=bordercolor, bd=0, highlightthickness=0, class_="Separator")
            separator.pack(fill=X, anchor=anchor)


class Table(Frame):
    def __init__(self, master, columns, column_weights=None, column_minwidths=None, height=None, minwidth=20,
                 minheight=20, padx=5, pady=5, cell_font=None, cell_foreground="black", cell_background="white",
                 cell_anchor=W, header_font=None, header_background="white", header_foreground="black",
                 header_anchor=CENTER, bordercolor="#999999", innerborder=True, outerborder=True,
                 stripped_rows=("#EEEEEE", "white"), on_change_data=None):
        outerborder_width = 1 if outerborder else 0

        Frame.__init__(self, master, highlightbackground=bordercolor, highlightcolor=bordercolor,
                       highlightthickness=outerborder_width, bd=0)

        self._cell_background = cell_background
        self._cell_foreground = cell_foreground
        self._cell_font = cell_font
        self._cell_anchor = cell_anchor

        self._number_of_rows = 0
        self._number_of_columns = len(columns)

        self._stripped_rows = stripped_rows

        self._padx = padx
        self._pady = pady

        self._bordercolor = bordercolor
        self._innerborder_width = 1 if innerborder else 0

        self._data_vars = []

        self._columns = columns

        for j in range(len(columns)):
            column_name = columns[j]

            header_cell = Header_Cell(self, text=column_name, borderwidth=self._innerborder_width, font=header_font,
                                      background=header_background, foreground=header_foreground, padx=padx, pady=pady,
                                      bordercolor=bordercolor, anchor=header_anchor)
            header_cell.grid(row=0, column=j, sticky=N + E + W + S)

        if column_weights is None:
            for j in range(len(columns)):
                self.grid_columnconfigure(j, weight=1)
        else:
            for j, weight in enumerate(column_weights):
                self.grid_columnconfigure(j, weight=weight)

        if column_minwidths is not None:
            self.update_idletasks()
            for j, minwidth in enumerate(column_minwidths):
                if minwidth is None:
                    header_cell = self.grid_slaves(row=0, column=j)[0]
                    minwidth = header_cell.winfo_reqwidth()
                self.grid_columnconfigure(j, minsize=minwidth)

        if height is not None:
            self._append_n_rows(height)

        self._on_change_data = on_change_data

    def _append_n_rows(self, n):
        number_of_rows = self._number_of_rows
        number_of_columns = self._number_of_columns

        for i in range(number_of_rows + 1, number_of_rows + n + 1):
            list_of_vars = []
            for j in range(number_of_columns):
                var = StringVar()
                list_of_vars.append(var)

                if self._stripped_rows:
                    cell = Data_Cell(self, borderwidth=self._innerborder_width, variable=var,
                                     bordercolor=self._bordercolor, padx=self._padx, pady=self._pady,
                                     background=self._stripped_rows[(i + 1) % 2], foreground=self._cell_foreground,
                                     font=self._cell_font, anchor=self._cell_anchor)
                else:
                    cell = Data_Cell(self, borderwidth=self._innerborder_width, variable=var,
                                     bordercolor=self._bordercolor, padx=self._padx, pady=self._pady,
                                     background=self._cell_background, foreground=self._cell_foreground,
                                     font=self._cell_font, anchor=self._cell_anchor)
                cell.grid(row=i, column=j, sticky=N + E + W + S)

            self._data_vars.append(list_of_vars)

        self._number_of_rows += n

    def _pop_n_rows(self, n):
        number_of_rows = self._number_of_rows
        number_of_columns = self._number_of_columns
        for i in range(number_of_rows - n + 1, number_of_rows + 1):
            for j in range(number_of_columns):
                self.grid_slaves(row=i, column=j)[0].destroy()

            self._data_vars.pop()

        self._number_of_rows -= n

    def set_data(self, data):
        n = len(data)
        m = len(data[0])

        number_of_rows = self._number_of_rows

        if number_of_rows > n:
            self._pop_n_rows(number_of_rows - n)
        elif number_of_rows < n:
            self._append_n_rows(n - number_of_rows)

        for i in range(n):
            for j in range(m):
                self._data_vars[i][j].set(data[i][j])

        if self._on_change_data is not None: self._on_change_data()

    def get_data(self):
        number_of_rows = self._number_of_rows
        number_of_columns = self._number_of_columns

        data = []
        for i in range(number_of_rows):
            row = []
            row_of_vars = self._data_vars[i]
            for j in range(number_of_columns):
                cell_data = row_of_vars[j].get()
                row.append(cell_data)

            data.append(row)
        return data

    @property
    def number_of_rows(self):
        return self._number_of_rows

    @property
    def number_of_columns(self):
        return self._number_of_columns

    def row(self, index, data=None):
        number_of_columns = self._number_of_columns

        if data is None:
            row = []
            row_of_vars = self._data_vars[index]

            for j in range(number_of_columns):
                row.append(row_of_vars[j].get())

            return row
        else:
            if len(data) != number_of_columns:
                raise ValueError("data has no %d elements: %s" % (number_of_columns, data))

            row_of_vars = self._data_vars[index]
            for j in range(number_of_columns):
                row_of_vars[index][j].set(data[j])

            if self._on_change_data is not None: self._on_change_data()

    def column(self, index, data=None):
        number_of_rows = self._number_of_rows

        if data is None:
            column = []

            for i in range(number_of_rows):
                column.append(self._data_vars[i][index].get())

            return column
        else:

            if len(data) != number_of_rows:
                raise ValueError("data has no %d elements: %s" % (number_of_rows, data))

            for i in range(self._number_of_columns):
                self._data_vars[i][index].set(data[i])

            if self._on_change_data is not None: self._on_change_data()

    def clear(self):
        number_of_rows = self._number_of_rows
        number_of_columns = self._number_of_columns

        for i in range(number_of_rows):
            for j in range(number_of_columns):
                self._data_vars[i][j].set("")

        if self._on_change_data is not None: self._on_change_data()

    def delete_row(self, index):
        i = index
        while i < self._number_of_rows:
            row_of_vars_1 = self._data_vars[i]
            row_of_vars_2 = self._data_vars[i + 1]

            j = 0
            while j < self._number_of_columns:
                row_of_vars_1[j].set(row_of_vars_2[j])

            i += 1

        self._pop_n_rows(1)

        if self._on_change_data is not None: self._on_change_data()

    def insert_row(self, data, index=END):
        self._append_n_rows(1)

        if index == END:
            index = self._number_of_rows - 1

        i = self._number_of_rows - 1
        while i > index:
            row_of_vars_1 = self._data_vars[i - 1]
            row_of_vars_2 = self._data_vars[i]

            j = 0
            while j < self._number_of_columns:
                row_of_vars_2[j].set(row_of_vars_1[j])
                j += 1
            i -= 1

        list_of_cell_vars = self._data_vars[index]
        for cell_var, cell_data in zip(list_of_cell_vars, data):
            cell_var.set(cell_data)

        if self._on_change_data is not None: self._on_change_data()

    def cell(self, row, column, data=None):
        """Get the value of a table cell"""
        if data is None:
            return self._data_vars[row][column].get()
        else:
            self._data_vars[row][column].set(data)
            if self._on_change_data is not None: self._on_change_data()

    def __getitem__(self, index):
        if isinstance(index, tuple):
            row, column = index
            return self.cell(row, column)
        else:
            raise Exception("Row and column indices are required")

    def __setitem__(self, index, value):
        if isinstance(index, tuple):
            row, column = index
            self.cell(row, column, value)
        else:
            raise Exception("Row and column indices are required")

    def on_change_data(self, callback):
        self._on_change_data = callback




if __name__ == "__main__":
    try:
        import tkinter as tk
        from tkinter import ttk
        from tkinter import Frame, Label, Message, StringVar
        from tkconstants import *
        from tkinter import csv
        import csv

    except ImportError:
        import tkinter as tk
        from tkinter import ttk


        # 한 줄씩 tuple의 형태로 담김
        with open('data_example.csv', 'r') as csv_file:
            # reader = csv.reader(f)
            # your_list = list(reader)
            csv_reader = csv.reader(csv_file)
            your_list = list(csv_reader)

            # with open('data_example_new.csv', 'w') as new_file:
            #     csv_writer = csv.writer(new_file, delimeter='/t')
            #
            #     for line in csv_reader:
            #         csv_writer.writerow(line)

        # line in csv
        print(your_list[0])
        # day
        print(your_list[0][0])
        # time
        print(your_list[0][1])
        # lecture_room
        print(your_list[0][2])
        # information
        print("호호"+your_list[0][3])
        print(len(your_list))
        # print("your list" + len(your_list))


        print(your_list[1])
        print(your_list[1][0])
        print(your_list[1][1])
        #
        # print(your_list[2])
        # print(your_list[3])
        # print(your_list[4])
        # print(your_list[5])
        # print(your_list[6])


        lecture_room_row_fixed = ['2117호','2119호','2124호','2125호','2248호','2249호','2401호','2402호','2403호','2407호',
                                '2408호','2409호','2410호','2121호','2121a호','2314호','2315호','2316호','담헌102호']
        day_col_fixed = ['월','월','월','월','화','화','화','화','수','수','수','수','목','목','목','목','금','금','금','금']
        timeslot_col_fixed = ['9시-11시', '11시-13시', '14시-16시', '16시-18시','9시-11시', '11시-13시', '14시-16시', '16시-18시',
                              '9시-11시', '11시-13시', '14시-16시', '16시-18시','9시-11시', '11시-13시', '14시-16시', '16시-18시',
                              '9시-11시', '11시-13시', '14시-16시', '16시-18시']

        # list_combined size 20
        list_combined = ['','','','','','','','','','','','','','','','','','','','']
        for i in range(0, 20):
            list_combined[i] = day_col_fixed[i] + timeslot_col_fixed[i]

        print("하하"+list_combined[0])

        if '월9시-' and '11' and '18' in list_combined[0]+lecture_room_row_fixed[0]:
            print("yes")

        # for i in range(0, 20)
        # if your_list[][0] + your_list[room_idx][1] in list_combined:

        # for i in range(len(your_list)):
        #     print your_list[i][0] + your_list[i][1]
        #     if your_list[i][0] + your_list[i][1] in list_combined:
        #         if your_list[i][2] in lecture_room_row_fixed:




    win = tk.Tk()
    win.title("Time Schedule")

    # with open('data_example.csv', 'r') as csv_file:
    #     csv_reader = csv.reader(csv_file)
    #
    #     for line in csv_reader:
    #         print(line)

    # 맨 첫줄, 컬럼+컬럼명 생성
    table = Table(win, ["요일", "시간", "2117호", "2119호", "2124호", "2125호",
                        "2248호","2249호","2401호","2402호","2403호","2407호",
                        "2408호", "2409호", "2410호", "2121호","2121a호",
                        "2314호","2315호","2316호","담헌102호"], column_minwidths=[None, None, None])
    table.pack(expand=True, fill=X, padx=10, pady=10)

    # 기본 세팅 값

    # table.set_data([["mon", "9-11", "subcode1, subname1, divclass1, kim", "subcode1, subname1, divclass1, lee", "subcode1, subname1, divclass1, lee", "subcode1, subname1, divclass1, lee"]])
    # table.set_data([["mon", "11", "subcode1, subname1, divclass1, kim", "subcode1, subname1, divclass1, lee", "subcode1, subname1, divclass1, lee", "subcode1, subname1, divclass1, lee"]])
    # table.set_data([["mon", "9", "subcode1, subname1, divclass1, lee", "subcode1, subname1, divclass1, lee",0,1]])
    # table.set_data([["mon", "9", "subcode1, subname1, divclass1, lee", "subcode1, subname1, divclass1, lee",0,1]])
    # table.set_data([["mon", "9", "subcode1, subname1, divclass1, lee", "subcode1, subname1, divclass1, lee","subcode1, subname1, divclass1, lee",1]])

    # table.set_data([["mon", "9", "subcode1, subname1, divclass1, kim", 0], [4, 5, 6, 0], [7, 8, 9, 0], [10, 11, 12, 0]])
    # table.set_data([["mon", "9", "subcode1, subname1, divclass1, kim", 0], [4, 5, 6, 0], [7, 8, 9, 0], [10, 11, 12, 0]])

    # table.set_data([["월", "9-11", 0, 0], [4, 5, 6, 0], [7, 8, 9, 0], [10, 11, 12, 0]])
    # table.set_data([[0, 0, 0, 0], [4, 5, 6, 0], [7, 8, 9, 0], [10, 11, 12, 0]])


    table.set_data([[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []])


    for i in range(0,20):
        table.cell(i, 0, day_col_fixed[i])
        table.cell(i, 1, timeslot_col_fixed[i])

    # 요일,시간 고정, 강의실 체크
    count = 0;
    # 0~19
    for day_time_idx, day_time_data in enumerate(list_combined):
        # 0~20
        for room_idx, room_data in enumerate(lecture_room_row_fixed):
            for i in range(len(your_list)):
                if your_list[i][0] and your_list[i][1] == list_combined[i]:
                    if your_list[i][2] in lecture_room_row_fixed:
                        print("yesss")
                        table.cell(0, room_idx+2, "1")

        count = count + 1
        print(count)
    # for room in lecture_room_row_fixed:
    #     for day_time in list_combined:
    #         if room





    # csv file data
    # 0~19 (20개 for문)
    # for i in range(0, 20):
    #     table.cell(i, 0, your_list[i][0])
    #     table.cell(i, 1, your_list[i][1])


    # table.cell(0, 2, your_list[0][0])
    # table.cell(1, 2, your_list[0][0])
    # table.cell(0, 3, your_list[0][1])
    # table.cell(0, 4, your_list[0][2])
    # table.cell(0, 5, your_list[0][3])
    # table.cell(0, 0, " a fdas fasd fasdf asdf asdfasdf asdf asdfa sdfas asd sadf ")
    # table.cell(0, 1, " a fdas fasd fasdf asdf asdfasdf asdf asdfa sdfas asd sadf ")
    # table.cell(0, 2, " a fdas fasd fasdf asdf asdfasdf asdf asdfa sdfas asd sadf ")
    # table.cell(0, 3, " a fdas fasd fasdf asdf asdfasdf asdf asdfa sdfas asd sadf ")
    # table.cell(0, 4, " a fdas fasd fasdf asdf asdfasdf asdf asdfa sdfas asd sadf ")
    # table.cell(0, 5, " a fdas fasd fasdf asdf asdfasdf asdf asdfa sdfas asd sadf ")
    # table.cell(0, 6, " a fdas fasd fasdf asdf asdfasdf asdf asdfa sdfas asd sadf ")
    # table.cell(0, 7, " a fdas fasd fasdf asdf asdfasdf asdf asdfa sdfas asd sadf ")


# table = Table()
win.mainloop()
