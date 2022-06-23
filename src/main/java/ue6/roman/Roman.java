package ue6.roman;

import java.util.TreeMap;

public class Roman {

    private int romanInt;
    private String romanStr;
    private final RuntimeException InvalidRomanNumeral= new RuntimeException("There is a problem with the roman numeral!");

    public Roman(int romanInt) {
        if(romanInt< 1 || romanInt> 3999){
            throw InvalidRomanNumeral;
        }
        this.romanInt= romanInt;
        this.romanStr= intToRoman(romanInt);
    }

    public Roman(String romanStr) {
        invalidRomanThrowException(romanStr);
        this.romanStr= romanStr;
        this.romanInt= romanToInt(romanStr);
    }

    public Roman add(Roman r){
        return new Roman(this.romanInt + r.romanInt);
    }

    public Roman subtract(Roman r){
        return new Roman(this.romanInt - r.romanInt);
    }

    public Roman multiply(Roman r){
        return new Roman(this.romanInt * r.romanInt);
    }

    public Roman divide(Roman r){
        return new Roman(this.romanInt / r.romanInt);
    }

    @Override
    public String toString() {
        return this.romanStr;
    }

    @Override
    public int hashCode() {
        return romanInt;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        if(this.hashCode() == ((Roman)obj).hashCode()){
            return true;
        }
        return false;
    }

    public int getInteger(){
        return romanInt;
    }

    private void invalidRomanThrowException(String str){
        char[] romanChars = str.toCharArray();
        for (int i = 0; i < romanChars.length; i++) {
            romanSymbbolValue(romanChars[i]);
        }
    }


    private int romanToInt(String str){
        char[] romanChars = str.toCharArray();
        int romanIntValue = 0;
        int tempCurrent, tempNext;
        char tempChar = ' ';
        int charRepeatCounter = 0;

        for (int i = 0; i < romanChars.length; i++) {
            if(Character.compare(tempChar, romanChars[i]) != 0){
                tempChar = romanChars[i];
                charRepeatCounter = 1;
            }else {
                charRepeatCounter++;
            }
            if(charRepeatCounter > 3){
                throw InvalidRomanNumeral;
            }else if(charRepeatCounter == 2){
                if(romanSymbbolValue(romanChars[i]) == 5 || romanSymbbolValue(romanChars[i]) == 50 ||
                        romanSymbbolValue(romanChars[i]) == 500 ){
                    throw InvalidRomanNumeral;
                }
            }
            tempCurrent = romanSymbbolValue(romanChars[i]);
            if(i < romanChars.length - 1){
                tempNext = romanSymbbolValue(romanChars[i+1]);
                if(tempCurrent >= tempNext){
                    romanIntValue += tempCurrent;
                }else{
                    romanIntValue += tempNext - tempCurrent;
                    i++;
                }
            }else{
                romanIntValue += tempCurrent;
            }
        }
        return romanIntValue;
    }

    private String intToRoman(int input){
        TreeMap<Integer, String > values = new TreeMap<>();
        values.put(1000, "M");
        values.put(900, "CM");
        values.put(500, "D");//
        values.put(400, "CD");
        values.put(100, "C");
        values.put(90, "XC");
        values.put(50, "L");//
        values.put(40, "XL");
        values.put(10, "X");
        values.put(9, "IX");
        values.put(5, "V");//
        values.put(4, "IV");
        values.put(1, "I");
        int currentInt = values.floorKey(input);
        if(currentInt == input){
            return values.get(input);
        }else {
            return values.get(currentInt) + intToRoman(input - currentInt);
        }
    }

    private int romanSymbbolValue(char chr){
        switch(chr){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw InvalidRomanNumeral;
        }
    }
}
