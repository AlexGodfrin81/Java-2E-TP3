package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {

	/**
	 * Constructeur
	 */
         int score;
         int tour;
         int[][] boules = {{-1,-1},
                           {-1,-1},
                           {-1,-1},
                           {-1,-1},
                           {-1,-1},
                           {-1,-1},
                           {-1,-1},
                           {-1,-1},
                           {-1,-1},
                           {-1,-1},
                           {-1,-1},
                           {-1,-1}};
         
	public SinglePlayerGame() {
            this.score = 0;
            this.tour = 0;
            
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
        
	public void lancer(int nombreDeQuillesAbattues) {
            boolean Spare = (this.tour >= 1 && this.boules[this.tour-1][0] + this.boules[this.tour-1][1] == 10 );
            boolean Strike = (this.tour >= 1 && this.boules[this.tour-1][0] == 10 );
            if (this.boules[this.tour][0] == -1 && this.tour <= 9){
                System.out.println("Tour : "+this.tour);
                this.boules[this.tour][0] = nombreDeQuillesAbattues;
            } else {
                if (this.boules[this.tour][0] == 10 && this.tour <= 9){
                    this.boules[this.tour][1] = 0;
                    this.boules[this.tour+1][0] = nombreDeQuillesAbattues;
                } else {
                    this.boules[this.tour][1] = nombreDeQuillesAbattues;
                }
                if (Strike){
                    this.score += 2*(this.boules[this.tour][0] + this.boules[this.tour][1]);
                } else {
                    if (Spare){
                        this.score += 2*this.boules[this.tour][0] + this.boules[this.tour][1];
                    } else {
                        this.score += this.boules[this.tour][0] + this.boules[this.tour][1];
                    }
                    
                }
                System.out.print(this.boules[this.tour][0]+" ");
                System.out.println(this.boules[this.tour][1]);
                System.out.println("Score du joueur : "+score());
                System.out.println();
                this.tour += 1;
            }
            
	}

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
		return this.score;
	}
}
