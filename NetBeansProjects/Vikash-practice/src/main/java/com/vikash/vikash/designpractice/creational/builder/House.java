package com.vikash.vikash.designpractice.creational.builder;

public class House {
    private int plotNumber;
    private String location;
    private String street;
    private boolean isSwimming;

    private House(Builder builder) {
        this.plotNumber = builder.plotNumber;
        this.location = builder.location;
        this.street = builder.street;
        this.isSwimming = builder.isSwimming;
    }

    @Override
    public String toString() {
        return "House{" +
                "plotNumber=" + plotNumber +
                ", location='" + location + '\'' +
                ", street='" + street + '\'' +
                ", isSwimming=" + isSwimming +
                '}';
    }

    public static class Builder{
        private int plotNumber;
        private String location;
        private String street;
        private boolean isSwimming;

        public Builder setPlotNumber(int plotNumber) {
            this.plotNumber = plotNumber;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setSwimming(boolean swimming) {
            isSwimming = swimming;
            return this;
        }

        public House build()
        {
            return new House(this);
        }
    }
}

