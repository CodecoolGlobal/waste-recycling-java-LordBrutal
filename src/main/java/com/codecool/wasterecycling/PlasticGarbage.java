package com.codecool.wasterecycling;

public class PlasticGarbage extends Garbage {

        private boolean clean;

        public PlasticGarbage(String name, Boolean clean) {
                super(name);
                this.clean = clean;
        }

        public void clean () {
                clean = true;
        }

        public boolean isClean () {
                return clean;
        }
}
