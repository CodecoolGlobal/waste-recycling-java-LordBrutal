package com.codecool.wasterecycling;

import java.util.Arrays;

public class Dustbin {

        private String color;
        protected Garbage[] houseWasteContent;
        protected Garbage[] plasticGarbageContent;
        protected Garbage[] paperGarbageContent;

        public Dustbin(String color) {
                this.color = color;
        }

        public String getColor() {
                return color;
        }

        public void throwOutGarbage(Garbage garbage) {
                if (garbage instanceof PaperGarbage) {
                        if (((PaperGarbage) garbage).isSqueezed()) {
                                paperGarbageContent = increaseSize(paperGarbageContent);
                                paperGarbageContent[paperGarbageContent.length - 1] = garbage;
                                System.out.printf("%s is successfully thrown into the %s Dustbin!%n", garbage.getName(), color);
                        }
                        else try {
                                throw new DustbinContentException();
                        } catch (DustbinContentException e) {
                                System.out.println("You have to squeeze it first!");
                        }

                }
                else if (garbage instanceof PlasticGarbage) {
                        if (((PlasticGarbage) garbage).isClean()) {
                                plasticGarbageContent = increaseSize(plasticGarbageContent);
                                plasticGarbageContent[plasticGarbageContent.length - 1] = garbage;
                                System.out.printf("%s is successfully thrown into the %s Dustbin!%n", garbage.getName(), color);
                        }
                        else try {
                                throw new DustbinContentException();
                        } catch (DustbinContentException e) {
                                System.out.println("You have to clean it first!");
                        }
                }
                else  {
                        houseWasteContent = increaseSize(houseWasteContent);
                        houseWasteContent[houseWasteContent.length - 1] =  garbage;
                        System.out.printf("%s is successfully thrown into the %s Dustbin!%n", garbage.getName(), color);
                }
        }

        public int getHouseWasteCount () {
                if (houseWasteContent!=null) {
                        return houseWasteContent.length;
                }
                return 0;
        }

        public int getPaperCount () {
                if (paperGarbageContent!=null) {
                        return paperGarbageContent.length;
                }
                return 0;
        }

        public int getPlasticCount () {
                if (plasticGarbageContent!=null) {
                        return plasticGarbageContent.length;
                }
                return 0;
        }

        public void emptyContents () {
                houseWasteContent = null;
                paperGarbageContent = null;
                plasticGarbageContent = null;
        }

        public void displayContents () {
                System.out.println(this);
        }

        @Override
        public String toString() {
                StringBuilder dustbinContentString = new StringBuilder();
                dustbinContentString.append(String.format("%n%s Dustbin!%nHouse waste content: %d item(s) ", getColor(), getHouseWasteCount()));
                if (houseWasteContent!=null) {
                        for (int i = 0; i < getHouseWasteCount(); i++) {
                                dustbinContentString.append(String.format("%s nr.%d ", houseWasteContent[i].getName(), i+1));
                        }
                }
                dustbinContentString.append(String.format("%nPaper content: %d item(s) ", getPaperCount()));
                if (paperGarbageContent!=null) {
                        for (int i = 0; i < getPaperCount(); i++) {
                                dustbinContentString.append(paperGarbageContent[i].getName()).append(" nr.").append(i + 1);
                        }
                }
                dustbinContentString.append("\nPlastic content: ").append(getPlasticCount()).append(" item(s) ");
                if (plasticGarbageContent!=null) {
                        for (int i = 0; i < getPlasticCount(); i++) {
                                dustbinContentString.append(plasticGarbageContent[i].getName()).append(" nr.").append(i+1);
                        }
                }
                return dustbinContentString.toString();
        }

        private Garbage[] increaseSize (Garbage[] garbageContainer) {
                if (garbageContainer==null) {
                        return new Garbage[1];
                }
                Garbage[] newContainer;
                newContainer = Arrays.copyOf(garbageContainer, garbageContainer.length+1);
                return newContainer;
        }
}
