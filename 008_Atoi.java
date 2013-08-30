public int atoi(String str) {
    	str = str.trim();
		if (str.length() == 0)
			return 0;
		boolean hasSign = false;
		int sign = 1;
		int pre = 0, ans = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+' || str.charAt(i) == '-' || (str.charAt(i) >= '0' && str.charAt(i) <= '9')){
				int j = i;
				if (str.charAt(j) == '-') {
					hasSign = true;
					sign = -1;
					j++;
				}
				if (str.charAt(j) == '+') {
					hasSign = true;
					j++;
				}
				while (j < str.length() && str.charAt(j) >= '0' && str.charAt(j) <= '9') {
					pre = ans;
					ans = ans * 10 + (str.charAt(j) - '0');
					if ((ans & 0x80000000) == 0x80000000) {
						ans = pre;
						return sign == 1 ? 0x7fffffff : 0x80000000;
					}
                    j++;
                    if (j > 10 + (hasSign ? 1 : 0)) {
                    	return sign == 1 ? 0x7fffffff : 0x80000000;
                    }
				}
				break;
			}else{
				return 0;
			}
		}
		return sign * ans;
    }