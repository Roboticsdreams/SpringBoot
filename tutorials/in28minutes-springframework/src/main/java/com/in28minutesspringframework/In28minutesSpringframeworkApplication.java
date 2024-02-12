package com.in28minutesspringframework;

import com.in28minutesspringframework.c01_tightcoupling.AppGamingBasicJava_TC;
import com.in28minutesspringframework.c02_loosecoupling_interface.AppGamingBasicJava_LC;
import com.in28minutesspringframework.c03_loosecoupling_springlevel1.AppHelloworldSpring;
import com.in28minutesspringframework.c04_loosecoupling_springlevel2.AppGamingSpringBean;
import com.in28minutesspringframework.c05_springcreateobjects.AppGamingSpringBeanWithComponentScan;
import com.in28minutesspringframework.c06_dependencyinjectiontypes.ConstructorBasedDepInjection;
import com.in28minutesspringframework.c06_dependencyinjectiontypes.FieldBasedDepInjection;
import com.in28minutesspringframework.c06_dependencyinjectiontypes.SetterBasedDepInjection;
import com.in28minutesspringframework.c07_exercises.RealworldSpringContextExercise;
import com.in28minutesspringframework.c08_eagerandlazyinit.LazyInitialization;
import com.in28minutesspringframework.c09_beanscope.BeanScopeLauncher;
import com.in28minutesspringframework.c10_prepostanotations.PrePostAnnotationLauncher;
import com.in28minutesspringframework.c11_jakartaCDI.CDILauncher;
import com.in28minutesspringframework.c12_xmlconfiguration.XMLConfigurationLauncher;
import com.in28minutesspringframework.c13_stereotypeannotations.RealworldSpringContext;

public class In28minutesSpringframeworkApplication {

	public static void main(String[] args) {
		System.out.println("In28minutesSpringframeworkApplication");
		System.out.println("\n\nc01_tightcoupling");
		AppGamingBasicJava_TC.main(args);
		System.out.println("\n\nc02_loosecoupling_interface");
		AppGamingBasicJava_LC.main(args);
		System.out.println("\n\nc03_loosecoupling_springlevel1");
		AppHelloworldSpring.main(args);
		System.out.println("\n\nc04_loosecoupling_springlevel2");
		AppGamingSpringBean.main(args);
		System.out.println("\n\nc05_springcreateobjects");
		AppGamingSpringBeanWithComponentScan.main(args);
		System.out.println("\n\nc06_dependencyinjectiontypes");
		SetterBasedDepInjection.main(args);
		FieldBasedDepInjection.main(args);
		ConstructorBasedDepInjection.main(args);
		System.out.println("\n\nc07_exercises");
		RealworldSpringContextExercise.main(args);
		System.out.println("\n\nc08_eagerandlazyinit");
		LazyInitialization.main(args);
		System.out.println("\n\nc09_beanscope");
		BeanScopeLauncher.main(args);
		System.out.println("\n\nc10_prepostanotations");
		PrePostAnnotationLauncher.main(args);
		System.out.println("\n\nc11_jakartaCDI");
		CDILauncher.main(args);
		System.out.println("\n\nc12_xmlconfiguration");
		XMLConfigurationLauncher.main(args);
		System.out.println("\n\nc13_stereotypeannotations");
		RealworldSpringContext.main(args);
	}
}
