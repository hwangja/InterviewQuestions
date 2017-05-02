package questions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/**
 * A menu contains a list of items with a set of prices. Given a budget, get all
 * combinations of orders that can be ordered. All money must be spent
 *
 */
public class GenerateMenuCombinations {

	public List<List<BigDecimal>> getMenuOptions(BigDecimal[] priceList, BigDecimal limit) {
		List<BigDecimal> startingList = new ArrayList<>();
		List<List<BigDecimal>> acceptedPrices = new ArrayList<>();
		backtrace(priceList, 0, acceptedPrices, startingList, limit);
		return acceptedPrices;
	}
	
	public void backtrace(BigDecimal[] priceList, int pos,
			List<List<BigDecimal>> finalizedList, List<BigDecimal> acceptedPrices,
			BigDecimal remainder) {

		if (remainder.equals(BigDecimal.ZERO)) {
			finalizedList.add(acceptedPrices);
			return;
		}

		if (pos == priceList.length) {
			return;
		}

		// progress without including the particular item
		final List<BigDecimal> notIncludedCopy = new ArrayList<>();
		notIncludedCopy.addAll(acceptedPrices);
		backtrace(priceList, pos+1, finalizedList, notIncludedCopy, remainder);
		
		// consider the particular item if it's either equal to, or less than the remaining value
		if (priceList[pos].compareTo(remainder) <= 0) {
			final List<BigDecimal> includedCopy = new ArrayList<>();
			includedCopy.addAll(acceptedPrices);
			includedCopy.add(priceList[pos]);
			backtrace(priceList, pos, finalizedList, includedCopy, remainder.subtract(priceList[pos]));
		}
	}
	
	public static void main(String[] args) {
		BigDecimal[] priceList = new BigDecimal[2];
		priceList[0] = BigDecimal.ONE;
		priceList[1] = BigDecimal.ONE.add(BigDecimal.ONE);

		BigDecimal limit = new BigDecimal("2.5");
		GenerateMenuCombinations operation = new GenerateMenuCombinations();
		System.out.println(operation.getMenuOptions(priceList, limit));
	}
	
}
