package serenitylabs.tutorials;

/**
 * Created by Home on 21-Dec-16.
 */
public enum TextConverterForHour {
/*
    _1("one"),
    _2("two"),
    _3("three"),
    _4("four"),
    _5("five"),*/
    _12("twelve");


    private  final String label;


    TextConverterForHour(  final String label){
        this.label = label;
    }

    public String label(){
        return label;
    }

//    public String getCode() {
//        return code;
//    }
//
//    public String getLabel() {
//        return label;
//    }

//    public static String convertText(int hour){
//        String hr = "_"+hour;
//        for(TextConverterForHour textHour : valueOf(hr)){
//
//            String code = textHour.getCode();
//            if(code.equalsIgnoreCase(hr)){
//                return textHour.getLabel();
//            }
//        }
//        return null;
//    }

}
