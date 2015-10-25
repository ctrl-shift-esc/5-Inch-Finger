# 5-Inch-Finger

Once upon a time, there was a little prince with a spare laptop. He thought it would be awesome to turn it in to a multimedia machine. When the prince installed Ubuntu and started watching netflix, he noticed that there was a lag in the audio feed. This annoyed the prince and made him mad. He searched far and wide for any solutions. He consulted so many wise seers and one of them, called StackOverflow, gave him a magic file as a work around for his problem. The mighty seer instructed the prince to bind the execution of this file to a key combination on the keyboard. But the prince's keyboard was 5 inches too far from his comfort reach.

So the brave prince thought, he could just make his phone do all the work instead of him. This idea led him to create a Python script as a server, set on his old laptop, and the android app as a client, on his phone.

This repository hosts the source of both the client and the server.

# How it works

The python script is in an infinite loop, always listening to connections on port 26262. When a new connection is made, it switches the Bluetooth profile from A2DP to HSP to A2DP. The switching of these profiles is what resets the audio lag. The android app connects to the IP address given in the app, on port 26262. The connection on the app side is disconnected, while the server is constantly listening for a conection.

# Finished goods

While the python script can be downloaded from here, the ready-to-fly android app can be downloaded from the app store. 

