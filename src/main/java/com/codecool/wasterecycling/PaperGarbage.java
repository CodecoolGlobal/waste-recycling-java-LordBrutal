package com.codecool.wasterecycling;

public class PaperGarbage extends Garbage {

        private boolean squeezed;

        public PaperGarbage (String name, Boolean squeezed) {
                super(name);
                this.squeezed = squeezed;
        }

        public void squeeze () {
                squeezed  = true;
                System.out.printf("%s is squeezed successfully!%n", getName());
        }

        public boolean isSqueezed () {
                return squeezed;
        }
}
