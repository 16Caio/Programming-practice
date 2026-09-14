import Auxiliares.ListNode;

public class Add_Two_Numbers {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(4, l1);
		ListNode l3 = new ListNode(2, l2);
		// 2 -> 4 -> 3
		
		ListNode L1 = new ListNode(4);
		ListNode L2 = new ListNode(6, L1);
		ListNode L3 = new ListNode(5, L2);
		// 5 -> 6 -> 4	
		
		ListNode resultante = addTwoNumbers(l3, L3);
		printLista(resultante);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

	    ListNode pontoDePartida = new ListNode(0);
	    
        ListNode atual = pontoDePartida;
        
        // é a dezena passando para a próxima casa
        // ex: 9 + 6 = 15 --> mantém o 5 e vai 1 para próxima casa
        int vaiUm = 0;
        
        // enquanto os 3 não forem 0, o loop é repetido
        while (l1 != null || l2 != null || vaiUm != 0) {
            // se l1 for diferente de null, x = valor de l1, se não x = 0
        	int x = (l1 != null) ? l1.val : 0;
        	
        	// se l2 for diferente de null, y = valor de l2, se não y = 0
            int y = (l2 != null) ? l2.val : 0;
            
            int soma = vaiUm + x + y;
            
            // a dezena vai pro vaiUm (que será usada na soma da próxima casa)
            vaiUm = soma / 10;
            
            // o seguinte do atual terá o valor da unidade da soma
            atual.next = new ListNode(soma % 10);
            
            // atual passa a ser o seguinte
            atual = atual.next;
            
            // se não forem null, avançam para o próximo 
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return pontoDePartida.next;
				
	}
	
	public static void printLista(ListNode l1) {
		if(l1 == null) {
			return;
		}
		
		System.out.println(l1.val);
		printLista(l1.next);
	}
}