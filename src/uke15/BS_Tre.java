package uke15;

public class BS_Tre<T extends Comparable<T>> {

    private BinaerTreNode<T> rot;

    public static void main(String[] args) {
        BS_Tre<Integer> tre = new BS_Tre<>();

        tre.rot = new BinaerTreNode<>(10);
        tre.rot.venstre = new BinaerTreNode<>(5);
        tre.rot.hogre = new BinaerTreNode<>(15);
        tre.rot.venstre.venstre = new BinaerTreNode<>(2);
        tre.rot.venstre.hogre = new BinaerTreNode<>(7);
        tre.rot.hogre.hogre = new BinaerTreNode<>(20);

        tre.skrivVerdier(5, 15);  
    }

    public void skrivVerdier(T nedre, T ovre) {
        skrivVerdierRek(rot, nedre, ovre);
        
        System.out.println("\nmer effektiv:");
        skrivVerdierEffektiv(rot, nedre, ovre);
    }
  //denne koden går gjennom hver node i subtreet istedet for å bare huske at venstre er mindre og høyre er større
    
    private void skrivVerdierRek(BinaerTreNode<T> t, T min, T maks) {
        if (t != null) {
            skrivVerdierRek(t.getVenstre(), min, maks);
            if ((t.getElement().compareTo(min) >= 0) &&
                (t.getElement().compareTo(maks) <= 0)) {
                System.out.print(t.getElement() + " ");
            }
            skrivVerdierRek(t.getHogre(), min, maks);
        }
    }

    private static class BinaerTreNode<T> {
        private T element;
        private BinaerTreNode<T> venstre, hogre;

        public BinaerTreNode(T element) {
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public BinaerTreNode<T> getVenstre() {
            return venstre;
        }

        public BinaerTreNode<T> getHogre() {
            return hogre;
        }
    }
    
    private void skrivVerdierEffektiv(BinaerTreNode<T> node, T min, T maks) {
    	if(node == null) {
    		return;
    	}
    	
    	T verdi =node.getElement();
    	int cmpMin=verdi.compareTo(min);
    	int cmpMaks=verdi.compareTo(maks);
    	
    	if(cmpMin > 0) {
    		skrivVerdierEffektiv(node.getVenstre(), min, maks);
    	}
    	
    	if(cmpMin>=0 && cmpMaks <= 0) {
    		System.out.print(verdi + " ");
    		
    	}
    	if(cmpMaks < 0) {
    		skrivVerdierEffektiv(node.getHogre(), min, maks);
    	}
    }
    
}
