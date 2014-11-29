package com.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class ElectronConfigMain {
	public static List<Orbital> allOrbital = new ArrayList<Orbital>();
	public static List<SimpleOrbital> allSimple = new ArrayList<SimpleOrbital>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Please input the total electron");
		Scanner in = new Scanner(System.in);
		int total_e = in.nextInt();
		double n = Math.sqrt(total_e / 2);
		createSimpleOrbital((int) n + 1);
		Atom atom = new Atom(total_e);


		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");

			// go !
			// for (int i = total_e; i >= 0; i--) {
			// kSession.insert(allOrbital);
			// kSession.fireAllRules();
			// }
			// for (Orbital orbital : allOrbital) {
			// kSession.insert(orbital);
			// }
			for (SimpleOrbital orbital : allSimple) {
				kSession.insert(orbital);
			}
			kSession.insert(atom);
			kSession.fireAllRules();

			// if (atom.getListOfOrbital() != null) {
			// List<Orbital> args1 = atom.getListOfOrbital();
			// for (int i = 0; i < args1.size(); i++) {
			// System.out.println(args1.get(i));
			// }
			// }
			Collections.sort(allSimple);
			for (SimpleOrbital orb : allSimple) {
				
				if (orb.getElectron() > 0) {
					System.out.print(orb.toString() + " ");
				}
			}

		

			// Orbital configuredAtom = (Orbital)
			// atom.getListOfOrbital().get(0);
			// System.out.println(configuredAtom.toString());
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static void createOrbital(int maxShell) {

		for (int n = 1; n <= maxShell; n++) {
			for (int l = Orbital.s; l <= n - 1; l++) {
				for (int ml = -l; ml <= l; ml++) {
					allOrbital.add(new Orbital(n, l, ml));
				}
			}
		}
	}

	public static void createSimpleOrbital(int maxShell) {
		for (int n = 1; n <= maxShell; n++) {
			for (int l = SimpleOrbital.s; l <= n - 1; l++) {
				allSimple.add(new SimpleOrbital(n, l));
			}
		}
	}

}
