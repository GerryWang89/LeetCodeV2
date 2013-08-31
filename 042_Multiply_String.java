public String multiply(String num1, String num2) {
		String ret = "0";
		for (int i = 0; i < num2.length(); i++) {
			ret = add(ret,singleMul(num1, num2.charAt(i), num2.length() - 1 - i));
		}
		if (ret.replaceAll("[0]+", "-").equals("-")) {
			return "0";
		}
		return ret;
	}

	public String singleMul(String num1, char num2, int digit) {
		if (num2 - '0' == 0) {
			return "0";
		}
		String ret = "";
		int carry = 0;
		for (int i = num1.length() - 1; i >= 0; i--) {
			int value = (num1.charAt(i) - '0') * (num2 - '0') + carry;
			ret = value % 10 + ret;
			carry = value / 10;
		}
		if (carry != 0)
			ret = carry + ret;
		for (int i = 0; i < digit; i++)
			ret += "0";
		return ret;
	}

	public String add(String num1, String num2) {
		if (num2.equals("0") || num2.equals("")) {
			return num1;
		}
		if (num1.equals("0") || num1.equals("")) {
			return num2;
		}
		String ret = "";
		int carry = 0;
		while (!num1.equals("") && !num2.equals("")) {
			int digit = (num1.charAt(num1.length() - 1) - '0')
					+ (num2.charAt(num2.length() - 1) - '0');
			ret = (digit + carry) % 10 + ret;
			carry = (digit + carry) / 10;
			num1 = num1.substring(0, num1.length() - 1);
			num2 = num2.substring(0, num2.length() - 1);
		}
		if (num1.equals("")) {
			ret = add(num2, carry + "") + ret;
		} else {
			ret = add(num1, carry + "") + ret;
		}
		return ret;
	}