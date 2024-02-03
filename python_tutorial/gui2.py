import tkinter as tk

class Application(tk.Frame):
    def __init__(self, master=None):
        super().__init__(master)
        self.quit = None
        self.master = master
        self.pack(expand=True, fill="both")
        self.create_widget()

    def create_widget(self):
        self.quit = tk.Button(self, text="Button", command=self.master.destroy)
        self.quit.place(x=80, y=80)


root = tk.Tk()
root.geometry("200x200")
app = Application(master=root)
app.mainloop()