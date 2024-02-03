import threading
import time
import socket
import queue


def loop_start(q):
    def listen(q):
        host = "localhost"
        port = 12345
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        sock.bind((host, port))
        sock.listen()
        while q.empty():
            conn, addr = sock.accept()
            data = conn.recv(1024).decode()  # decodeを追加してバイナリを文字列に変換
            if data == "quit":  # クライアントから"quit"が送られてきたとき
                q.put(True)  # qにTrueを挿入
                break  # ループを終了

    threading.Thread(target=listen, args=(q,)).start()
    while q.empty():
        time.sleep(3)
        print("now looping")


if __name__ == "__main__":
    q = queue.Queue()
    threading.Thread(target=loop_start, args=(q,)).start()
