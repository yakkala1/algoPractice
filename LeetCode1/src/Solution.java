import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	int nItems;
	HashMap<Quantity,Integer> memory;
	Set<BuyingOption> buyingOptions;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    	this.nItems = price.size();
        buyingOptions = generateBuyingOptions(price,special);
        memory = new HashMap<Quantity,Integer>();
        memory.put( new Quantity(nItems),0 );
        Quantity requiredQuantity = new Quantity(needs);
        return solve(requiredQuantity);
    }

	private int solve(Quantity quantity) {
		if( !memory.containsKey(quantity) )
			memory.put(quantity, calculate(quantity));
		return memory.get(quantity);
	}

	private Integer calculate(Quantity quantity) {
		int minimumPrice = Integer.MAX_VALUE;
		for(BuyingOption option : buyingOptions) {
			Quantity subQ = substract(quantity,option.quantity);
			if( isValid(subQ) ) {
				int tempPrice = solve(subQ);
				int price = tempPrice+option.price;
				minimumPrice = Math.min(price, minimumPrice);
			}
		}
		return minimumPrice;
	}

	private boolean isValid(Quantity quantity) {
		for(int q: quantity.list) {
			if(q<0)
				return false;
		}
		return true;
	}

	private Quantity substract(Quantity quantity, List<Integer> list) {
		List<Integer> newList = new ArrayList<Integer>();
		for(int i=0; i<list.size(); i++) {
			newList.add( quantity.list.get(i) - list.get(i) );
		}
		return new Quantity(newList);
	}

	private Set<BuyingOption> generateBuyingOptions(List<Integer> prices, List<List<Integer>> special) {
		Set<BuyingOption> ret = new HashSet<BuyingOption>();
		for(int i=0; i<nItems; i++) {
			int price = prices.get(i);
			ret.add( new BuyingOption(i,price) );
		}
		for(List<Integer> offer : special) {
			ret.add( new BuyingOption(offer) );
		}
		return ret;
	}
	
	class BuyingOption {
		public List<Integer> quantity;
		public int price;
		public BuyingOption() {
			this.quantity = getList(nItems);
			this.price = 0;
		}
		public BuyingOption(int item, int price) {
			this.quantity = getList(nItems);
			this.quantity.set(item, price);
			this.price = price;
		}
		public BuyingOption(List<Integer> offer) {
			List<Integer> temp = getList(offer.size()-1);
			for(int i=0; i<temp.size(); i++) {
				temp.set(i, offer.get(i));
			}
			this.quantity = temp;
			this.price = offer.get( offer.size()-1 );
		}
		private List<Integer> getList(int size) {
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<size; i++) {
				list.add(0);
			}
			return list;
		}
		@Override
		public boolean equals(Object object) {
			BuyingOption other = (BuyingOption)object;
			if( this.quantity.size() != other.quantity.size() )
				return false;
			for(int i=0; i<this.quantity.size(); i++) {
				if( this.quantity.get(i) != other.quantity.get(i) )
					return false;
			}
			return true;
		}
		@Override
		public int hashCode() {
			return toString().hashCode();
		}
		@Override
		public String toString() {
			String ret = "";
			for(int i=0; i<quantity.size(); i++) {
				ret += this.quantity.get(i)+",";
			}
			return ret;
		}
	}
	
	class Quantity {
		public List<Integer> list;
		public Quantity(List<Integer> quantity) {
			this.list = quantity;
		}
		public Quantity(int nItems) {
			this.list = new ArrayList<Integer>();
			for(int i=0; i<list.size(); i++) {
				this.list.add(0);
			}
		}
		@Override
		public boolean equals(Object object) {
			Quantity other = (Quantity)object;
			if( this.list.size() != other.list.size() )
				return false;
			for(int i=0; i<this.list.size(); i++) {
				if( this.list.get(i) != other.list.get(i) )
					return false;
			}
			return true;
		}
		@Override
		public int hashCode() {
			return toString().hashCode();
		}
		@Override
		public String toString() {
			String ret = "";
			for(int i=0; i<list.size(); i++) {
				ret += this.list.get(i)+",";
			}
			return ret;
		}
	}

}
