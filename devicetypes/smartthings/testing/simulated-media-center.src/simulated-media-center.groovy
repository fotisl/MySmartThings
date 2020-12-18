metadata {

    definition (name: "Simulated Media Center", namespace: "smartthings/testing", author: "fotisl", runLocally: false, mnmn: "SmartThings", vid: "generic-switch") {
        capability "Switch"
        capability "Relay Switch"
        capability "Sensor"
        capability "Actuator"
        capability "Health Check"
        capability "Audio Mute"
        capability "Audio Volume"
    }

    tiles {
        standardTile("switch", "device.switch", width: 2, height: 2, canChangeIcon: true) {
            state "off", label: '${currentValue}', action: "switch.on", icon: "st.switches.switch.off", backgroundColor: "#ffffff"
            state "on", label: '${currentValue}', action: "switch.off", icon: "st.switches.switch.on", backgroundColor: "#00A0DC"
        }
        standardTile("on", "device.switch", decoration: "flat") {
            state "default", label: 'On', action: "onPhysical", backgroundColor: "#ffffff"
        }
        standardTile("off", "device.switch", decoration: "flat") {
            state "default", label: 'Off', action: "offPhysical", backgroundColor: "#ffffff"
        }
        main "switch"
        details(["switch","on","off","deviceHealthControl"])
    }
}

def installed() {
    initialize()
}

def updated() {
    initialize()
}

private initialize() {
}

def parse(description) {
}

def on() {
    log.debug "on()"
    sendEvent(name: "switch", value: "on")
}

def off() {
    log.debug "off()"
    sendEvent(name: "switch", value: "off")
}

def setMute(bool state) {
    log.debug "setMute(${state})"
    if(state)
        sendEvent(name: "mute", value: "muted");
    else
        sendEvent(name: "mute", value: "unmuted");
}

def setVolume(int volume) {
    log.debug "setVolume(${volume})"
    sendEvent(name: "volume", value: volume);
}

def volumeUp() {
    log.debug "volumeUp()"
}

def volumeDown() {
    log.debug "volumeDown()"
}
