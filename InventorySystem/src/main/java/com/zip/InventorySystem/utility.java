package com.zip.InventorySystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zip.InventorySystem.Parameter.ProductParam;
import com.zip.InventorySystem.type.ProductType;

public class utility {
	
	public static boolean isNullandEmpty(String str) {
		return (str == null || str.trim().isEmpty());
	}
	
	public static boolean isValidType(String type) {
		for (ProductType productType : ProductType.values()) {
            if (productType.name().equals(type)) {
                return true;
            }
        }
        return false;
    }
	
	public  static boolean isValidNumber(String number){
        Boolean resp = false;
        try {
            String expression = "[-+]?[0-9]*\\.?[0-9]+$";
            CharSequence inputStr = number;
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(inputStr);
            if( matcher.matches() ){
                resp = true;
            }
        }catch( Exception ex ){ }
        return resp;
}
	
	public static String isProductValid(ProductParam product) {
		String res = "";
		if( isNullandEmpty(product.getName()) ) {
			res = "Product Name is invalid.";
		}
		else if( !isValidType(product.getProductType().toString()) ) {
			res = "Product type is invalid.";
		}
		else if( !isValidNumber(product.getQuantity().toString()) ) {
			res = "Product quantity is invalid.";
		}
		else if( !isValidNumber(product.getPrice().toString()) ) {
			res = "Product price is invalid.";
		}
		
		return res;
	}

}
