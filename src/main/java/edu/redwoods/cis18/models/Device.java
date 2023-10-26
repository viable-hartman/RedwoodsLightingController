package edu.redwoods.cis18.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlElement;

public class Device {
    private final StringProperty deviceName = new SimpleStringProperty();
    private final IntegerProperty gpioNum = new SimpleIntegerProperty();
    private final IntegerProperty brightness = new SimpleIntegerProperty();
    private final IntegerProperty pixels = new SimpleIntegerProperty();

    private final StringProperty state = new SimpleStringProperty();


    @XmlElement(name = "deviceName")
    public String getDeviceName() {
        return deviceName.get();
    }

    public StringProperty deviceNameProperty() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName.set(deviceName);
    }

    @XmlElement(name = "gpioNum")
    public int getGpioNum() {
        return gpioNum.get();
    }

    public IntegerProperty gpioNumProperty() {
        return gpioNum;
    }

    public void setGpioNum(int gpioNum) {
        this.gpioNum.set(gpioNum);
    }

    @XmlElement(name = "brightness")
    public int getBrightness() {
        return brightness.get();
    }

    public IntegerProperty brightnessProperty() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness.set(brightness);
    }

    @XmlElement(name = "pixels")
    public int getPixels() {
        return pixels.get();
    }

    public IntegerProperty pixelsProperty() {
        return pixels;
    }

    public void setPixels(int pixels) {
        this.pixels.set(pixels);
    }

    @XmlElement(name = "state")
    public String getState() {
        return state.get();
    }

    public StringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }

    @Override
    public String toString() {
        return String.format(
                "Device: {Name: %s%nGPIO: %d%nBrightness: %d%nPixels: %d%nStatus: success}",
                this.getDeviceName(), this.getGpioNum(), this.getBrightness(), this.getPixels());
    }
}