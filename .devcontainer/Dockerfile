FROM archlinux:latest

WORKDIR /workspaces/chilean-ts-backend

ENV LANG en_US.UTF-8
ENV JAVA_HOME /usr/lib/jvm/java-21-openjdk
ENV PATH $JAVA_HOME/bin:$PATH

RUN pacman -Syu --noconfirm \
    && pacman -S --noconfirm jdk-openjdk maven git base-devel bash curl unzip openssh

RUN echo "en_US.UTF-8 UTF-8" > /etc/locale.gen && locale-gen
