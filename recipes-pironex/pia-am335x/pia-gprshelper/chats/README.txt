Configure provider dependent connect scripts here.

In most cases it is enough to copy on of the existing scripts, set the correct APN,
and change the gprs symlink to the newly created chat script.

If the SIM card requires a PIN to unlock, put it in pin.code and change the pin symlink to 
point to the pin.code file instead of pin.none.

After configuring the chat scripts, enable the pppd daemon with:
systemctl enable ppp
This will handle the module hardware and the pppd daemon.