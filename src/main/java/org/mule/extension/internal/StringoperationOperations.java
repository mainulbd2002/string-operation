package org.mule.extension.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Optional;

import javafx.scene.control.Separator;



/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class StringoperationOperations {

  /**
   * Example of an operation that uses the configuration and a connection instance to perform some action.
   */
  
  
  /*
   * String concat
   */
  
  @MediaType(value = ANY, strict = false)
  public String concatString(String stringA, String stringB) {
	  StringBuffer sb = new StringBuffer(stringA);
	  return sb.append(stringB).toString();
  }
  
  /*
   * String length
   */
  
  
  @MediaType(value = ANY, strict = false)
  public int stringLength(String inputString) {
	  return inputString.length();
  }
  
  /*
   * Sub string
   */
  
  
  /*@MediaType(value = ANY, strict = false)
  public String subString(String inputString, int beginIndex) {
	  return inputString.substring(beginIndex);
  }*/
  
  @MediaType(value = ANY, strict = false)
  public String subString(String inputString, 
		  int beginIndex, 
		  @Optional int endIndex) {
	  
	  if (endIndex > inputString.length())
		  endIndex = inputString.length();
	  
	  if (endIndex != 0)
		  return inputString.substring(beginIndex,endIndex);
	  else {
		  endIndex = inputString.length();
		  return inputString.substring(beginIndex,endIndex);
	  }
  }
  
  @MediaType(value = ANY, strict = false)
  public String subStringBeforeAfter(String inputString, 
		  @Optional boolean isAfter,
		  String separator) {
	  
	  if (isAfter) {
		 int position = inputString.indexOf(separator);
		 if (position > -1)
			 return inputString.substring(position + separator.length(), inputString.length());
		 else 
			 return "";
	  }
	  else {
		  int position = inputString.indexOf(separator);
		  if (position > -1)
			  return inputString.substring(0, position);
		  else
			  return "";
	  }
	  
	  
	  
	  
  }
  
  @MediaType(value = ANY, strict = false)
  public int getOccurance(String inputString, String separator, boolean ignoreCase) {
	  
	  if (separator.length() == 0)
		  return 0;
	  
	  int occurance = 0;
	  String opString = new String(inputString);
	  if (ignoreCase) {
		  opString = opString.toLowerCase();
		  separator = separator.toLowerCase();
	  }
	  int position = opString.length();
	  do {
		  position =opString.indexOf(separator);
		  if (position > -1) {
			  occurance++;
			  opString = opString.substring(position + separator.length());
		  }
	  }while(position > -1);
	  
	  return occurance;
	  
  }
  
  
  @MediaType(value = ANY, strict = false)
  public String subStringAfterNthOccurance(String inputString, 
		  String separator,
		  int occurance,
		  boolean ignoreCase) {
	  
	  if (separator.length() == 0)
		  return "";
	  
	  int frequency = 0;
	  String opString = new String(inputString);
	  if (ignoreCase) {
		  opString = opString.toLowerCase();
		  separator = separator.toLowerCase();
	  }
	  int position = opString.length();
	  do {
		  position =opString.indexOf(separator);
		  if (position > -1) {
			  frequency++;
			  opString = opString.substring(position + separator.length());
		  }
	  }while(position > -1 && frequency < occurance);
	  
	  return opString;  
	  
	  
  }
  
  
  @MediaType(value = ANY, strict = false)
  public String reverse(String inputString) {
	  
	  StringBuffer sbf = new StringBuffer(inputString);
	  return sbf.reverse().toString();
	  
  }
  
  @MediaType(value = ANY, strict = false)
  public String toUpperCase(String inputString) {
	  
	  return inputString.toUpperCase();
	  
  }
  
  @MediaType(value = ANY, strict = false)
  public String toLowerCase(String inputString) {
	  
	  return inputString.toLowerCase();
	  
  }

	@MediaType(value = ANY, strict = false)
	public String removeSubString(String inputString,
							   String stringToRemove) {

  		if (stringToRemove.length() == 0){
  			return inputString;
		}

        String newStr = new String();
		String opStr = new String(inputString);
        int position = 0;

        do {
            position = opStr.indexOf(stringToRemove);
            if (position > 0){
                newStr += opStr.substring(0, position);
                opStr = opStr.substring(position+ stringToRemove.length());
            }
        }while(position > 0);

        newStr = newStr + opStr;

        return newStr;

	}

    @MediaType(value = ANY, strict = false)
    public String replaceSubString(String inputString,
                                  String stringToReplace,
                                   String stringToReplaceWith) {

        if (stringToReplace.length() == 0){
            return inputString;
        }

        if (stringToReplaceWith.length() == 0){
            return removeSubString(inputString, stringToReplace);
        }

        String newStr = new String();
        String opStr = new String(inputString);
        int position = 0;

        do {
            position = opStr.indexOf(stringToReplace);
            if (position > 0){
                newStr += opStr.substring(0, position) + stringToReplace;
                opStr = opStr.substring(position+ stringToReplace.length());
            }
        }while(position > 0);

        newStr = newStr + opStr;

        return newStr;

    }

	@MediaType(value = ANY, strict = false)
	public int contains(String inputString,
						   String stringToTest){

  		return inputString.indexOf(stringToTest);
	}
  

}
