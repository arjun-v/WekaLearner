package AssociationRules;

import java.io.BufferedReader;
import java.io.FileReader;

import weka.associations.Apriori;
import weka.associations.AssociationRule;
import weka.associations.AssociationRules;
import weka.core.Instances;
import weka.core.Utils;

public class AprioriAssociationRules {

	public void build(String file, String options ){

		try {
						BufferedReader bReader = new BufferedReader(new FileReader(file));
			Instances instances = new Instances(bReader);
			bReader.close();

			instances.deleteAttributeType(0);
			boolean isNumericAttributePresent = instances.checkForAttributeType(0);

			if (isNumericAttributePresent) {
				System.out.println("Instances should be pre-processed correctly");
			}

			Apriori apriori = new Apriori();
			apriori.setOptions(Utils.splitOptions(options));
			apriori.buildAssociations(instances);

			AssociationRules rules = apriori.getAssociationRules();

			for (AssociationRule rule : rules.getRules()) {
				System.out.println(rule.toString());
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}