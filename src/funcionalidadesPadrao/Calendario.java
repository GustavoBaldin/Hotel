package funcionalidadesPadrao;

import java.util.*;

public class Calendario {
    
    public int diferencaDias(int diaEntrada, int mesEntrada, int anoEntrada, 
    		int diaSaida, int mesSaida, int anoSaida) {
    	
    	Calendar data1 = new GregorianCalendar();
        Calendar data2 = new GregorianCalendar();
    	
        
        data1.set(Calendar.DAY_OF_MONTH, diaEntrada); 
        data1.set(Calendar.MONTH, mesEntrada);
        data1.set(Calendar.YEAR, anoEntrada);
        
        data2.set(Calendar.DAY_OF_MONTH, diaSaida); 
        data2.set(Calendar.MONTH, mesSaida);
        data2.set(Calendar.YEAR, anoSaida);
    	
        return calculoData(data1.getTime(), data2.getTime());
    }

    public int calculoData(Date d1, Date d2) {
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
    
    public boolean entreDatas(int diaEntrada, int mesEntrada, int anoEntrada, 
		int diaSaida, int mesSaida, int anoSaida, int diaEscolhido, int mesEscolhido,
		int anoEscolhido){
	
    	Calendar data1 = new GregorianCalendar();
        Calendar data2 = new GregorianCalendar();
        Calendar data3 = new GregorianCalendar();
    	
        
        data1.set(Calendar.DAY_OF_MONTH, diaEntrada); 
        data1.set(Calendar.MONTH, mesEntrada);
        data1.set(Calendar.YEAR, anoEntrada);
        
        data2.set(Calendar.DAY_OF_MONTH, diaSaida); 
        data2.set(Calendar.MONTH, mesSaida);
        data2.set(Calendar.YEAR, anoSaida);
        
        data3.set(Calendar.DAY_OF_MONTH, diaEscolhido); 
        data3.set(Calendar.MONTH, mesEscolhido);
        data3.set(Calendar.YEAR, anoEscolhido);
        
        return dateEntreDatas(data1.getTime(), data2.getTime(), data3.getTime());
    }
    
    public boolean dateEntreDatas(Date dInicio, Date dFinal, Date dEscolhida) {
    	
    	return dEscolhida.getTime() >= dInicio.getTime() && dEscolhida.getTime() <= dFinal.getTime();
    }
    
}