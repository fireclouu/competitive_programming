
public class ReverseInteger extends Tests<Integer, Integer>
{
	public ReverseInteger(boolean verbose) {
		super(verbose);
	}
	
	@Override
	void testInit() {
		mapTest.put(123, 321);
		mapTest.put(321, 123);
		mapTest.put(-123, -321);
		mapTest.put(1463847412, 2_147_483_641);
		mapTest.put(1_534_236_469, 0);
		mapTest.put(2_147_483_647, 0);
	}

	@Override
	Integer solution(Integer x) {
		// no other libraries ;)
		int res = 0, abs = x < 0 ? ~x + 1 : x;
		int digit;
		while (abs > 0) {
            // achieving low ms we sacrifice memory alloc so we dont repeat modulo operation
            digit = (abs % 10);
			res = (res * 10) + digit;

            // this one is  hacky trick to check
            // if overflow / underflow happens
            // we know rightmost value
            // will be adjusted unequal to
            // expected value
			if ((res % 10) != digit) return 0;
			abs /= 10;
		}

		// reverse
		return x < 0 ? ~res + 1 : res;
		
	}
}
