package com.codecool.wasterecycling;

public class Main {

    public static void main(String[] args) {

            Dustbin dustbin = new Dustbin("Purple");
            Garbage newGarbage = new Garbage("Half eaten sandwich");
            dustbin.throwOutGarbage(newGarbage);
            Garbage newGarbage2 = new Garbage("Rotten tomato");
            dustbin.throwOutGarbage(newGarbage2);
            PaperGarbage paperGarbage = new PaperGarbage("Failed exam", false);
            dustbin.throwOutGarbage(paperGarbage);
            PlasticGarbage plasticGarbage = new PlasticGarbage("Empty bottle of oil", false);
            plasticGarbage.clean();
            dustbin.throwOutGarbage(plasticGarbage);
            dustbin.displayContents();
            dustbin.emptyContents();
            dustbin.displayContents();

    }
}
