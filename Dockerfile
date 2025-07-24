FROM jenkins/jenkins:lts

USER root

# Install dependencies
RUN apt-get update && apt-get install -y \
    ca-certificates \
    curl \
    gnupg \
    lsb-release

# Add Docker’s official GPG key
RUN mkdir -p /etc/apt/keyrings && \
    curl -fsSL https://download.docker.com/linux/debian/gpg | \
    gpg --dearmor -o /etc/apt/keyrings/docker.gpg && \
    chmod a+r /etc/apt/keyrings/docker.gpg

# Add Docker repo (hardcoded to bullseye for stability)
RUN echo "deb [arch=amd64 signed-by=/etc/apt/keyrings/docker.gpg] \
https://download.docker.com/linux/debian bullseye stable" | \
    tee /etc/apt/sources.list.d/docker.list > /dev/null

# Install Docker CLI and Compose v2 plugin
RUN apt-get update && apt-get install -y \
    docker-ce-cli \
    docker-compose-plugin

# 🛠️ Fix: manually add docker group before usermod
RUN groupadd docker && usermod -aG docker jenkins

USER jenkins
