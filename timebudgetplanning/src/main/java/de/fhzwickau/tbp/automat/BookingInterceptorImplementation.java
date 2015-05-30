package de.fhzwickau.tbp.automat;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.fhzwickau.tbp.material.PlanningData;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.material.Task;
import de.fhzwickau.tbp.tools.dto.NewBooking;
import de.fhzwickau.tbp.tools.facade.BookingCommandTool;

@Interceptor
@BookingInterceptor
public class BookingInterceptorImplementation implements Serializable {

	@PersistenceContext
	private EntityManager entityManager;
	
	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		try {
			System.out.println("Interceptor called");
			NewBooking newBooking = (NewBooking) ic.getParameters()[0];
			Task t = entityManager.find(Task.class, newBooking.getTaskId());
			Project p = t.getMilestone().getProject();
			PlanningData latestPlanningData = null;
			for (PlanningData d : p.getPlanningData()) {
				if (latestPlanningData == null || latestPlanningData.getTstamp().getTime() < d.getTstamp().getTime()) {
					latestPlanningData = d;
				}
			}
			float budgetLimit = latestPlanningData.getTimeBudgetPlan();
			float currentTimeBudgetUsed = p.getTimeBudgetAct();
			if (currentTimeBudgetUsed + ((newBooking.getEnd().getTime() - newBooking.getStart().getTime() ) / 1000 / 60 / 60 ) > budgetLimit)
				System.out.println("Time Budget exceeded");
			else
				System.out.println("Time Budget okay");
			
			ic.proceed();
			return null;			
		}
		finally {}
	}
	
}
