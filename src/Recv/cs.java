package Recv;

import edu.cmu.sphinx.decoder.ResultListener;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.PropertyException;
import edu.cmu.sphinx.util.props.PropertySheet;
//Cette classe sert à écouter les actions d'utilisateur en ce qui concerne la commande vocale 
//Pour savoir si l'utilisateur a dit quelque chose ou non 
public class cs implements ResultListener {
private boolean s=false;
private GridPanel gp;
	public cs(GridPanel gp) {
	super();
	this.gp = gp;
}

	public boolean isS() {
	return s;
}

	@Override
	public void newProperties(PropertySheet arg0) throws PropertyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newResult(Result arg0) {
		//Si l'utilisateur a dit quelque chose
		gp.setF(false);
	}

}
