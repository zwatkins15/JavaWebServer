JavaWebServer
=============

A simple web server written in Java

Starting out as a project to help a friend of mine.
Who knows, maybe it can be a neat project I work on.

=============
= Usage
=============
Running the .class will obviously start the
server. It does contain a few arguments that
you may use if you wish, but all are optional.

------COMMANDS------
Defaults are as follows:
-p (PORT): 80
-ip (LISTEN ADDRESS): 127.0.0.1
-max (MAX CONNECTIONS): 10

Commands are as follows:
-p(--port) [1-65535]
 Specify port for the server to listen on.
-ip(--listenon) [0.0.0.0 - 255.255.255.255]
 Specify the INetAddress for the server to listen on.
-max(--maxconnections) [1 - 999]
 This may take some more work later, but at the moment it
 serves as the backlog integer for java's ServerSocket.
 Supposedly it limits the ammount of concurrent connections.
 Since the server will eventually be threaded this might
 not be necassary.
--------------------

-------Files--------
The only notable folders at the moment are:
 -bin (java classes)
 -src (java sources)
 -www (web server root directory)
--------------------