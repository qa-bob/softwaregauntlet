package com.herokuapp.theinternet.region.header;

import com.softwareonpurpose.validator4test.Validator;

 public class TheInternetHeaderValidator extends Validator{
     private static final String DESCRIPTION = "Header";
     private final TheInternetHeaderExpected expected;
     private final TheInternetHeader actual;

     private TheInternetHeaderValidator(TheInternetHeaderExpected expected, TheInternetHeader actual, Validator parentValidator) {
         super(DESCRIPTION, expected, actual, parentValidator);
         this.expected = expected;
         this.actual = actual;
     }

     @Override
    protected void executeVerifications() {
        verify("Image Source", expected.getImageSource(), actual.getImageSource());
        verify("Alternate Text", expected.getAlternateText(), actual.getAlternateText());
    }

     public static TheInternetHeaderValidator getInstance(TheInternetHeaderExpected expected, TheInternetHeader actual, Validator parent) {
         return new TheInternetHeaderValidator(expected, actual, parent);
     }
 }
