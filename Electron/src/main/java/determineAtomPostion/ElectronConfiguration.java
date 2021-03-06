/**
 * 
 */
package determineAtomPostion;

/**
 * @author imrul
 *
 */
public class ElectronConfiguration {
	
	 
	public static void main(String[] args){
		//s
		//56
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s2","4d10","5p6","6s2"};
		//d
		//25
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","3d5","4s2"};
		
		
		
		//Exception
		
		//29
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","3d10","4s1"};
		//24
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","3d5","4s1"};
		//30
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","3d10","4s2"};
		//44
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s1","4d7"};
		//45
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s1","4d8"};
		//46
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s1","4d9"};
		//47
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s1","4d10"};
		//57
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s2","4d10","5p6","6s2","5d1"};
		//58
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s2","4d10","5p6","6s2","5d2"};
		//64
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s2","4d10","5p6","6s2","5d8"};
		//96
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s2","4d10","5p6","6s2","4f14","5d10","6p6","7s2","6d8"};
		//79
		String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s2","4d10","5p6","6s1","4f14","5d10"};

		//109
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s2","4d10","5p6","6s2","4f14","5d10","6p6","7s2","5f14","6d7"};
		//111
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s2","4d10","5p6","6s2","4f14","5d10","6p6","7s2","5f14","6d9"};	
		//p
		//35
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","3d10","4s2","4p5"};
		//53
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","3d10","4s2","4p6","4d10","5s2","5p5"};
		//113
		//String[] eConfig ={"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s2","4d10","5p6","6s2","4f14","5d10","6p6","7s2","5f14","6d10","7p1"};
		//f
		//100
		//String[] eConfig = {"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s2","4d10","5p6","6s2","4f14","5d10","6p6","7s2","5f12"};
		//98
		//String[] eConfig ={"1s2","2s2","2p6","3s2","3p6","4s2","3d10","4p6","5s2","4d10","5p6","6s2","4f14","5d10","6p6","7s2","5f10"};
		ElectronConfiguration configuration = new ElectronConfiguration();
		AtomPostion postion = configuration.getAtomPosition(eConfig);
//		System.out.println("Block :"+postion.getBlock());
		System.out.println("Column :"+postion.getColumn());
		System.out.println("Row :"+postion.getRow());
	}
	
	/*
	 *  Method to set AtomPosition Object
	 * 
	 **/
	public AtomPostion getAtomPosition(String[] electronConfiguration){
		AtomPostion position = new AtomPostion();
		position.setBlock(getBlock(electronConfiguration));
		position.setRow(getRowFromEconfig(electronConfiguration));
		position.setColumn(getColumn(electronConfiguration, getBlock(electronConfiguration)));
		return position;
	}
	
	/*
	 * Method to Determine Block from Electron configuration 
	 * 
	 **/
	public static String getBlock(String[] eConf){
		String block = null;
		String outerOrbital = getRowFromEconfig(eConf);
		if(!hasOrbital(eConf, outerOrbital+"s1")){
			if(!hasOrbital(eConf, outerOrbital+"p")){
				if(hasOrbital(eConf, String.valueOf(Integer.valueOf(outerOrbital)-1)+"d")){
					// F or d
					if(isCorrectLimit(eConf, String.valueOf(Integer.valueOf(outerOrbital)-1)+"d" , 1, 10) && !hasOrbital(eConf, String.valueOf(Integer.valueOf(outerOrbital)-2)+"f14")){
						block = "D";
					}else if(isCorrectLimit(eConf, String.valueOf(Integer.valueOf(outerOrbital)-1)+"d" , 2, 10) && hasOrbital(eConf, String.valueOf(Integer.valueOf(outerOrbital)-2)+"f14")){
						block = "D";
					}else{
						block = "F";
					}
				}else{
					// F or S
					if(hasOrbital(eConf, outerOrbital+"s2") && hasOrbital(eConf, String.valueOf(Integer.valueOf(outerOrbital)-2)+"f")){
						block = "F";
					}else{
						block = "S";
					}
				}
			}else{
				block = "P";
			}
		}else{
			//D OR S
			if(hasOrbital(eConf, String.valueOf(Integer.valueOf(outerOrbital)-1)+"d") && isCorrectLimit(eConf, String.valueOf(Integer.valueOf(outerOrbital)-1)+"d", 1, 10)){
				block = "D";
			}else{
				block = "S";
			}
		}		
		return block;
	}
	
	/*
	 * Method to find ROW position from electron configuration 
	 * 
	 **/
	public static String getRowFromEconfig(String[] eConf){
		int rowValue = 0;
		String[] orbital = {"s","p","d","f"};
		for(int i =0;i < eConf.length; i++){
			for(int j=0; j< orbital.length; j++){
				if(eConf[i].contains(orbital[j])){
					String[] temp= eConf[i].split(orbital[j]);
					int t = Integer.valueOf(temp[0]);
					if(rowValue < t){
						rowValue = t;
					}
					break;
				}
			}
		}
		return String.valueOf(rowValue);
	}
	
	/*
	 * Method to find COLUMN position from electron configuration 
	 * 
	 **/
	public static String getColumn(String[] eConf, String block){
		String column = null;
		String dElectron = null;
		String fElectron =null;
		String sElectron = null;
		String pELectron = null;
		int c = 0;
		String outerOrbital = getRowFromEconfig(eConf);
		if(block.equalsIgnoreCase("F")){
			if(hasOrbital(eConf, String.valueOf(Integer.valueOf(outerOrbital)-1)+"d")){
				dElectron = getElectronByOrbital(eConf,String.valueOf(Integer.valueOf(outerOrbital)-1)+"d");
			}else{
				dElectron = "0";
			}
			if(hasOrbital(eConf, String.valueOf(Integer.valueOf(outerOrbital)-2)+"f")){
				fElectron = getElectronByOrbital(eConf,String.valueOf(Integer.valueOf(outerOrbital)-2)+"f");
			}else{
				fElectron = "0";
			}
			c = 2 + Integer.valueOf(dElectron.trim()) + Integer.valueOf(fElectron.trim());
			if(c >=8 && c <= 10){
				c = 8;
			}
			if(c >= 10 && c <= 12){
				c = c-10;
			}
			column = String.valueOf(c)+"B";
			if(c > 12){
				column = String.valueOf(c-10)+"A";
			}
		}
		if(block.equalsIgnoreCase("D")){
			if(hasOrbital(eConf, String.valueOf(Integer.valueOf(outerOrbital)-1)+"d")){
				dElectron = getElectronByOrbital(eConf,String.valueOf(Integer.valueOf(outerOrbital)-1)+"d");
			}else{
				dElectron = "0";
			}
			if(hasOrbital(eConf, String.valueOf(Integer.valueOf(outerOrbital))+"s")){
				sElectron = getElectronByOrbital(eConf,String.valueOf(Integer.valueOf(outerOrbital))+"s");
			}
			c = Integer.valueOf(sElectron) + Integer.valueOf(dElectron.trim());
			if(c >=8 && c <= 10){
				c = 8;
			}
			if(c > 10){
				c = c-10;
			}
			column = String.valueOf(c)+"B";
		}
		if(block.equalsIgnoreCase("P")){
			if(hasOrbital(eConf, outerOrbital.trim()+"p")){
				pELectron = getElectronByOrbital(eConf,outerOrbital.trim()+"p");
			}else{
				pELectron = "0";
			}
			if(hasOrbital(eConf, outerOrbital.trim()+"s")){
				sElectron = getElectronByOrbital(eConf,outerOrbital.trim()+"s");
			}
			column = String.valueOf(Integer.valueOf(sElectron.trim()) + Integer.valueOf(pELectron.trim()))+"A";
		}
		if(block.equalsIgnoreCase("S")){
			if(hasOrbital(eConf, outerOrbital.trim()+"s")){
				sElectron = getElectronByOrbital(eConf,outerOrbital.trim()+"s");
			}
			column = sElectron+"A";
		}
		return column;
	}
	
	/*
	 * Method to get total Number of electron from Electron Configuration
	 * 
	 **/
	public static int getTotalElectron(String[] eConf){
		int total = 0;
		String[] keys = {"s","p","d","f"};
		for(int i =0; i<eConf.length; i++){
			for(int j =0; j<keys.length;j++){
				if(eConf[i].toLowerCase().contains(keys[j].toLowerCase())){
					String[] temp = eConf[i].toLowerCase().split(keys[j].toLowerCase());
					total = total + Integer.valueOf(temp[1]);
					break;
				}
			}
		}
		return total;
	}
	
	/*
	 * Method to get electron by Orbital Name
	 * 
	 **/
	public static String getElectronByOrbital(String[] LastOrbitals, String OrbitalName){
		String[] electronNo = new String[2];
		for(int i = 0; i<LastOrbitals.length; i++){
			if(LastOrbitals[i].toLowerCase().contains(OrbitalName.toLowerCase())){
				electronNo = LastOrbitals[i].toLowerCase().split(OrbitalName);
				break;
			}
		}
		return electronNo[1];
	}
	
	/*
	 * Method to check orbital
	 * 
	 **/
	public static boolean hasOrbital(String[] electronConfig, String orbital){
		boolean flag = false;
		for(int i = 0; i<electronConfig.length; i++){
			if(electronConfig[i].toLowerCase().contains(orbital.toLowerCase())){
				flag = true;
				break;
			}
		}
		return flag;
	}

	/*
	 * Method to check correct electron limit
	 * 
	 **/
	public static boolean isCorrectLimit(String[] conf, String orbital, int start, int end){
		boolean flag = false;
		for(int i = 0; i< conf.length; i++){
			if(conf[i].toLowerCase().contains(orbital.toLowerCase())){
				String[] temp = conf[i].toLowerCase().split(orbital.toLowerCase());
				for(int j = start; j<=end; j++){
					if(Integer.valueOf(temp[1]) == j){
						flag = true;
						break;
					}
				}
			}
		}
		return flag;
	}
}
