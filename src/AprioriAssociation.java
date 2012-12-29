
import java.io.BufferedReader;
import java.io.FileReader;
import weka.core.Instances;
import weka.associations.Apriori;
import weka.associations.AssociationRule;
import weka.associations.AssociationRules;

public class AprioriAssociation {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader bReader = new BufferedReader(new FileReader("C:\\Program Files\\Weka-3-7\\data\\weather.arff"));
		
		Instances instances = new Instances(bReader);
		bReader.close();
		instances.deleteAttributeType(0);
		boolean isNumericAttributePresent = instances.checkForAttributeType(0);
		
		if (isNumericAttributePresent) {
			System.out.println("Instances should be pre-processed correctly");
		}
		
		Apriori apriori = new Apriori();
		apriori.buildAssociations(instances);
		AssociationRules rules = apriori.getAssociationRules();
		
		for (AssociationRule rule : rules.getRules()) {
			System.out.println(rule.toString());
		}
				
	}
	
}