package uke15;

public class BinaerTreNode<T> {
	
	
	public static void main(String[] args) {
        BinaerTreNode<Integer> rot = new BinaerTreNode<>(10);
        BinaerTreNode<Integer> venstre = new BinaerTreNode<>(5);
        BinaerTreNode<Integer> hoyre = new BinaerTreNode<>(15);
        BinaerTreNode<Integer> venstre1 = new BinaerTreNode<>(3);


        rot.setVenstre(venstre);
        rot.setHogre(hoyre);
        venstre.setVenstre(venstre1);

        venstre1.setHoydeU(1);
        venstre.setHoydeU(2);
        hoyre.setHoydeU(2);
        rot.setHoydeU(3);

        // Lager tre og setter rot
        BinaerTreNode<Integer>.BS_Tre<Integer> tre = rot.new BS_Tre<>();
        tre.rot = rot;

        // Sjekker balanse
        System.out.println("Er treet balansert? " + tre.erBalansert());
    }
	
	
	private T element;
	private BinaerTreNode<T> venstre, hogre;
	private int hoydeU;
	
	
	public T getElement() {
		return element;
	}


	public void setElement(T element) {
		this.element = element;
	}


	public BinaerTreNode<T> getVenstre() {
		return venstre;
	}


	public void setVenstre(BinaerTreNode<T> venstre) {
		this.venstre = venstre;
	}


	public BinaerTreNode<T> getHogre() {
		return hogre;
	}


	public void setHogre(BinaerTreNode<T> hogre) {
		this.hogre = hogre;
	}


	public int getHoydeU() {
		return hoydeU;
	}


	public void setHoydeU(int hoydeU) {
		this.hoydeU = hoydeU;
	}


	public BinaerTreNode(T element) {
		this.element = element;
		this.hoydeU = 1;
		
	}
	
	public class BS_Tre<T extends Comparable<T>> {
		private BinaerTreNode<T> rot;
		
		
	
	
	public boolean erBalansert() {
		return erBalansertRek(rot);
	}
	
	private boolean erBalansertRek(BinaerTreNode<T> node) {
		if(node == null) {
			return true; //et tomt tre er balansert
		}
		
		// if else setning
		int venstreHoyde = (node.getVenstre()!= null) ? node.getVenstre().getHoydeU() : 0;
		int hoyreHoyde = (node.getHogre()!= null) ? node.getHogre().getHoydeU() : 0;
		
		
		//ubalansert om treet sin forskjell er større enn 1
		if(Math.abs(venstreHoyde-hoyreHoyde)>1) {
			return false;
		}
		
		return erBalansertRek(node.getVenstre()) && erBalansertRek(node.getHogre());

	}
}
}
	