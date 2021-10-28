package com.codecool.wasterecycling;

public class PaperGarbage extends Garbage {

        private boolean squeezed;

        public PaperGarbage (String name, Boolean squeezed) {
                super(name);
                this.squeezed = squeezed;
        }

        public void squeeze () {
                squeezed  = true;
        }

        public boolean isSqueezed () {
                return squeezed;
        }
}
