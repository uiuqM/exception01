package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Digite o numero do quarto: ");
			int num = sc.nextInt();
			System.out.print("Digite a data de check-in (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Digite a data de check-out (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(num, checkin, checkout);
			System.out.println("Reserva: "+reservation);
			
			System.out.println("Digite os dados para atualizar a reserva: ");
			System.out.print("Digite a data de check-in (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Digite a data de check-out (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			reservation.updateDate(checkin, checkout);
			sc.close();
		}
		catch(ParseException e) {
			System.out.println("Erro na reserva: "+e.getMessage());
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: "+e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
	}

}
