curl -sSL https://get.docker.com/ | sh
sudo usermod -aG docker $(whoami)
service docker restart

# if you want to keep containers alive during daemon downtime.
# Adding "--live-restore" after "ExecStart=/usr/bin/dockerd -H fd://" in the file "/lib/systemd/system/docker.service".
# The file can get by the command "systemctl show --property=FragmentPath docker".
sudo sed -i 's/ExecStart=\/usr\/bin\/dockerd -H fd:\/\//ExecStart=\/usr\/bin\/dockerd -H fd:\/\/ --live-restore/' /lib/systemd/system/docker.service
sudo systemctl daemon-reload
sudo systemctl restart docker

# Install docker-compose
sudo curl -L "https://github.com/docker/compose/releases/download/1.9.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
docker-compose --version

# Install docker-machine
sudo curl -L "https://github.com/docker/machine/releases/download/v0.8.2/docker-machine-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-machine
sudo chmod +x /usr/local/bin/docker-machine
docker-machine -v

