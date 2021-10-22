package classes;

import java.util.Date;

public interface Alerte {

	public boolean declencherAlerte(Date d);
	public Lieu getLieu();
}
