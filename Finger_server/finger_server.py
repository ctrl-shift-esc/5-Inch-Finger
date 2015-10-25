import subprocess
import socket

s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.bind(('192.168.178.33',26262))
i = 1

while(1):
    s.listen(5)
    conn, addr = s.accept()
    data = conn.recv(2)
    if data != "":
        process = subprocess.check_output(['pactl', 'list', 'cards', 'short'])
        bluecard = process.split()[4]
        subprocess.check_output(['pactl', 'set-card-profile', bluecard, 'a2dp'])
        subprocess.check_output(['pactl', 'set-card-profile', bluecard, 'hsp'])
        subprocess.check_output(['pactl', 'set-card-profile', bluecard, 'a2dp'])
        print i + ". swaped"
        i = i + 1
    conn.close()
s.close()
