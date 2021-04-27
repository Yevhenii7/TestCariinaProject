package com.qaprosoft.carina.demo.allo.ua.model;

import java.util.Objects;

public class Phone {
    private String display;
    private String camera;
    private String ram;


    public Phone(String display, String camera, String ram) {
        this.display = display;
        this.camera = camera;
        this.ram = ram;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "display='" + display + '\'' +
                ", camera='" + camera + '\'' +
                ", ram='" + ram + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(getDisplay(), phone.getDisplay())
                && Objects.equals(getCamera(), phone.getCamera())
                && Objects.equals(getRam(), phone.getRam());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDisplay(), getCamera(), getRam());
    }
}
