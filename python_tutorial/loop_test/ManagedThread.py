import queue
import socket
import threading

class ManagedThread(threading.Thread):
    def __init__(self, target, *args, host:str, port: int):
        super().__init__(target=target, args=args)
        self._queue = queue.Queue()
        self._host = host
        self._port = port

    def run(self):
        def listen(q: queue.Queue):
            with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:
                sock.bind((self._host, self._port))
                sock.listen(5)
                while True:
                    conn, addr = sock.accept()
                    with conn:
                        data = conn.recv(1024).decode()
                        if data == 'quit':
                            q.put('quit')
                            break

        listener = threading.Thread(target=listen, args=(self._queue,))
        listener.start()
        while self._queue.empty():
            self.start()
        listener.join()



    def stop(self):
        pass

def func():
    pass


ManagedThread(target=func, host="127.0.0.1", port=6789).start()