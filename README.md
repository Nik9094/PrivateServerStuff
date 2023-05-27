# PrivateServerStuff
This Minecraft 1.12.2 paper plugin handles world loading/joining in my private server, using Multiverse-Core. It also has a few other utilities to make player experience smooth enough.
This isn't made for public use, therefore it's not completely scalable (or well-built) and has some quirks related to the server it "manages".


## Features
### World loading
The plugin loads worlds at startup, assuming they've already been imported in Multiverse-Core. Use config.yml to change which worlds to load in.
Might edit it and auto-import worlds.


### Join worlds through signs
The plugin reads the world name (file name/MV alias) from a sign and teleports you to it. In my particular case it also performs a command from another plugin.
Just place a sign with "Join map" in the second line, and the world's name on the third line.

## Commands (the most useful ones)
/restarter <message>: Broadcasts a message and restarts the server 5 minutes after the command has been sent. Console-only command.


/maintenance <message>: Similar to /restarter, this broadcasts a message, turns on whitelist and restarts the server. This is intended to be a very basic "maintenance mode", for my usecase I didn't need anything extra. Console-only command.

/hub: Teleports a player back to the hub. The hub's MV alias or filename must be "Hub".

/fly: Lets users fly... Obviously.