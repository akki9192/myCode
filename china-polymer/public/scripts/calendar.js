
function Calendar (cname, id, date)
{
	// Used to notify the calendar that it is attached to a single html field.
	this.fallback_single = 0;
	
	// Used to notify the claendar that it is attached to 3 html fields.
	this.fallback_multi = 1;
	
	// Used to notify the calendar that it is attached to both field sets.
	this.fallback_both = 2;
	
	// Read-only calendar
	this.viewOnly = false;
	
	// Allows the user to select weekends
	this.allowWeekends = true;
	
	// Allows the user to select weekdays
	this.allowWeekdays = true;
	
	// The minimum date that the user can select (inclusive)
	this.minDate = "--";
	
	// The maximum date that the user can select (exclusive)
	this.maxDate = "--";
	
	// Allow the user to scroll dates
	this.scrolling = true;
	
	// The id of this calendar
	this.name = cname;
	
	// The first day of the week in the calendar (0-Sunday, 6-Saturday)
	this.firstDayOfWeek = 0;
	
	// Fallback method
	this.fallback = this.fallback_both;
	
	// Sets the date and strips out time information
	this.calendarDate = date;
	/*this.calendarDate.setUTCHours(0);
	this.calendarDate.setUTCMinutes(0);
	this.calendarDate.setUTCSeconds(0);
	this.calendarDate.setUTCMilliseconds(0);*/
	
	// The field id that the calendar is attached to.
	// For single input, this is used "as is". for the
	// Multi-input, it is given a suffix for _day, _month
	// and _year inputs.
	this.attachedId = id;
	
	// The left and right month control icons
	this.controlLeft = "&#171;";
	this.controlRight = "&#187;";
	this.style="width: 1165px;";
		
	// The left and right month control icons (when disabled)
	this.controlLeftDisabled = "";
	this.controlRightDisabled = "";
	
	// The css classes for the calendar and header
	this.calendarStyle = 'font-size:10pt;font-family:verdana;padding:0px;margin:0px;border:none; border-collapse:collapse;';
	this.headerStyle = 'background-color:#CCCCCC;padding:0px;margin:0px;border:none; border-collapse:collapse;';
	this.headerCellStyle = 'padding:2px;margin:1px;border:2px groove;text-align:center;width:3ex';
	this.headerCellStyleLabel = 'padding:2px;margin:1px;border:2px groove;text-align:center;';
	
	// The css classes for the rows
	this.weekStyle = "cal_week";
	this.evenWeekStyle = "background-color:#CCCCEE;padding:0px;margin:0px;border:none; border-collapse:collapse;";
	this.oddWeekStyle = "background-color:#AAAACC;padding:0px;margin:0px;border:none; border-collapse:collapse;";
	
	// The css classes for the day elements
	this.dayStyle = "width:3ex;text-align:center;padding:0px;margin:0px;border:none; border-collapse:collapse;cursor:hand;";
	this.disabledDayStyle = "color:#999999;width:3ex;padding:0px;margin:0px;border:none; border-collapse:collapse;";
	this.commonDayStyle = "color:black;width:3ex;padding:0px;margin:0px;border:none; border-collapse:collapse;";
	this.holidayDayStyle = "color:red;width:3ex;padding:0px;margin:0px;border:none; border-collapse:collapse;";
	this.eventDayStyle = "background-color:#40ff00;color:red;width:3ex;padding:0px;margin:0px;border:none; border-collapse:collapse;";
	this.todayDayStyle = "color:black;font-weight:bold;width:3ex;padding:0px;margin:0px;border:none; border-collapse:collapse;";
	
	// specifies the labels for this calendar
	this.dayLabels = new Array("Sun", "Mon", "Thu", "Wed", "Tue", "Fri", "Sat");
	this.monthLabels = new Array(
		"January", "February", "March", "April"
		, "May", "June", "July", "August"
		, "September", "October", "November", "December");
	
	// Specifies the dates of any event. The events are to be defined as arrays,
	// with element 0 being the date and element 1 being an id.
	this.eventDates = new Array();
	
	// Attach event handlers to any fallback fields.
	if (this.viewOnly == false) {
	
		setFieldValue(this.attachedId, this.calendarDate);
		
		/*if ((this.fallback = this.fallback_both) || (this.fallback = this.fallback_single)) {
			eval("document.getElementById(\"" + this.attachedId + "\").onchange = function () {updateFromSingle("+this.name+", this);}");
		}*/

		if ((this.fallback = this.fallback_both) || (this.fallback = this.fallback_multi)) {

			//eval("document.getElementById(\"" + this.attachedId + "_day\").onchange = function () {updateFromMultiDay("+this.name+", this);}");
			eval("document.getElementById(\"" + this.attachedId + "_month\").onchange = function () {updateFromMultiMonth("+this.name+", this);}");
			eval("document.getElementById(\"" + this.attachedId + "_year\").onchange = function () {updateFromMultiYear("+this.name+", this);}");
			
		}
	} 
	
	selectEvent = new Function();
}

function updateFromSingle (sender, helper) {
	newDate = new Date (helper.value);
	newDate.setUTCDate(newDate.getUTCDate()+1);
	sender.calendarDate = newDate;

	renderCalendar (sender);
	setFieldValue(sender.attachedId, sender.calendarDate);
}

function updateFromMultiDay (sender, helper) {

	if (isNaN(helper.value)) {
		helper.value = sender.calendarDate.getUTCDate();
		return false;
	}

	sender.calendarDate.setUTCDate(helper.value);
	renderCalendar (sender);
	setFieldValue(sender.attachedId, sender.calendarDate);
}

function updateFromMultiMonth (sender, helper) {

	if (isNaN(helper.value)) {
		helper.value = sender.calendarDate.getUTCMonths() -1;
		return false;
	}
	
	sender.calendarDate.setUTCMonth(helper.value-1);
	renderCalendar (sender);
	setFieldValue(sender.attachedId, sender.calendarDate);
}

function updateFromMultiYear (sender, helper) {

	if (isNaN(helper.value)) {
		helper.value = sender.calendarDate.getUTCFullYear();
		return false;
	}
	
	sender.calendarDate.setUTCFullYear(helper.value);
	renderCalendar (sender);
	setFieldValue(sender.attachedId, sender.calendarDate);
}

function getFirstCalendarDate (calendar)
{
	return new Date (
		calendar.calendarDate.getUTCFullYear()
		, calendar.calendarDate.getUTCMonth()
		, 1
	);
}

function renderCalendar (calendar)
{
	calHtml1 =  ("<table id=\"cal_" + calendar.attachedId + "\" class=\"" + calendar.calendarStyle + "\" style=\"" + calendar.style+"\">");
	calHtml1 += ((calendar.scrolling)?buildHeader(calendar):buildStaticHeader(calendar));
	calHtml1 += buildCalendarTable (calendar);
	calHtml1 += ("</table>");
	
	document.getElementById("cal_" + calendar.attachedId + "_display").innerHTML = calHtml1;
}

function scrollMonthBack (calendar)
{
	calendar.calendarDate.setUTCMonth(calendar.calendarDate.getUTCMonth() - 1);
	setFieldValue(calendar.attachedId, calendar.calendarDate);
	renderCalendar (calendar);
}

function selectDate (calendar, day)
{
	if (!calendar.viewOnly) {
		calendar.calendarDate.setUTCDate(day);
		setFieldValue(calendar.attachedId, calendar.calendarDate);
		renderCalendar (calendar);
	}
}

function scrollMonthForward (calendar)
{
	calendar.calendarDate.setUTCMonth(calendar.calendarDate.getUTCMonth() + 1);
	setFieldValue(calendar.attachedId, calendar.calendarDate);
	renderCalendar (calendar);
}

function setFieldValue(fieldId, date) {
	//document.getElementById(fieldId).value = date.getUTCFullYear() + "/" + (date.getUTCMonth()+1) + "/" + date.getUTCDate();
	document.getElementById(fieldId + "_year").value = date.getUTCFullYear();
	document.getElementById(fieldId + "_month").selectedIndex = date.getUTCMonth();
	//document.getElementById(fieldId + "_day").value = date.getUTCDate();
}

function buildHeader (calendar)
{

	enableLeft = true;
	enableRight = true;
	
	if (calendar.minDate != "--") 
	{
		if (calendar.calendarDate.getUTCFullYear() <= calendar.minDate.getUTCFullYear())
		{
			if (calendar.calendarDate.getUTCMonth() <= calendar.minDate.getUTCMonth())
			{
				enableLeft = false;
			}
		}
	}

	if (calendar.maxDate != "--") 
	{
		if (calendar.calendarDate.getUTCFullYear() >= calendar.maxDate.getUTCFullYear())
		{
			if (calendar.calendarDate.getUTCMonth() >= calendar.maxDate.getUTCMonth())
			{
				enableRight = false;
			}
		}
	}

	calHtml2 = "";
	
	calHtml2 +=  (
		"<tr style=\""
		+ calendar.headerStyle
		+ "\">");
	calHtml2 +=  (
		"<td style=\""
		+ calendar.headerCellStyle
		+ ((enableLeft)?("\" onclick=\"scrollMonthBack(" + calendar.name + ")"):"")
		+ "\">"
		+ ((enableLeft)?calendar.controlLeft:calendar.controlLeftDisabled)
		+ "</td>");
	calHtml2 +=  (
		"<td colspan=\"5\" style=\""
		+ calendar.headerCellStyleLabel
		+ "\">"
		+ calendar.monthLabels[calendar.calendarDate.getUTCMonth()] 
		+ ", " + calendar.calendarDate.getUTCFullYear()
		+ "</td>");
	calHtml2 +=  (
		"<td style=\""
		+ calendar.headerCellStyle
		+ ((enableRight)?("\" onclick=\"scrollMonthForward(" + calendar.name + ")"):"")
		+ "\">"
		+ ((enableRight)?calendar.controlRight:calendar.controlRightDisabled)
		+ "</td>");
	
	calHtml2 += ("</tr>");
	
	calHtml2 +=  (
		"<tr style=\""
		+ calendar.headerStyle
		+ "\">")

	for (i = 0; i < 7; i++) {
		showDay = i + calendar.firstDayOfWeek;
		if (showDay > 6) showDay = showDay - 7;
		calHtml2 +=  (
			"<td style=\""
			+ calendar.headerCellStyle
			+ "\">"
			+ calendar.dayLabels[showDay]
			+ "</td>");
	}

	calHtml2 += ("</tr>");
	return calHtml2
}

function buildStaticHeader (calendar)
{
	calHtml2 = "";
	
	calHtml2 +=  (
		"<tr style=\""
		+ calendar.headerStyle
		+ "\">");
	calHtml2 +=  (
		"<td colspan=\"7\" style=\""
		+ calendar.headerCellStyleLabel
		+ "\">"
		+ calendar.monthLabels[calendar.calendarDate.getUTCMonth()] 
		+ ", " + calendar.calendarDate.getUTCFullYear()
		+ "</td>");	
	calHtml2 += ("</tr>");
	
	calHtml2 +=  (
		"<tr class=\""
		+ calendar.headerStyle
		+ "\">")

	for (i = 0; i < 7; i++) {
		showDay = i + calendar.firstDayOfWeek;
		if (showDay > 6) showDay = showDay - 7;
		calHtml2 +=  (
			"<td style=\""
			+ calendar.headerCellStyle
			+ "\">"
			+ calendar.dayLabels[showDay]
			+ "</td>");
	}

	calHtml2 += ("</tr>");
	return calHtml2
}




function RenderDayDisabled (calendar, currentDate)
{
	calHtml += ('<td style="day">');
	calHtml += ("<span style=\"" + calendar.disabledDayStyle + "\">");
	calHtml += (currentDate.getUTCDate());
	calHtml += ("</span>");
	calHtml += ("</td>");
}

function RenderDayEnabled (calendar, currentDate, dayStyle)
{
	currentDayStyle = dayStyle;
	calHtml += ('<td style="day">');
	calHtml += ("<span style=\"" + dayStyle + "\" onclick=\"selectDate(" + calendar.name + ", " + currentDate.getUTCDate() + ")\">");
	calHtml += (currentDate.getUTCDate());
	calHtml += ("</span>");
	calHtml += ("</td>");
}

function RenderDayEvent (calendar, currentDate, dayStyle, eventId)
{
	currentDayStyle = dayStyle;
	calHtml += ('<td style="day">');
	calHtml += ("<span style=\"" + dayStyle + "\" onclick=\"selectDate(" + calendar.name + ", " + currentDate.getUTCDate() + "); " + calendar.name + ".selectEvent('" + eventId + "')\">");
	calHtml += (currentDate.getUTCDate());
	calHtml += ("</span>");
	calHtml += ("</td>");
}

function buildCalendarTable (calendar)
{
	currentDate = getFirstCalendarDate(calendar);
	odd = 0;
	while (currentDate.getUTCDay() != calendar.firstDayOfWeek)
	{
		currentDate.setUTCDate(currentDate.getUTCDate() - 1);
	}

	calHtml = "";
	do
	{
		odd += 1;

		calHtml +=  (
			"<tr style=\"" + (((odd%2)==0) ? calendar.evenWeekStyle : calendar.oddWeekStyle) + "\">")

		for (i = 0;i < 7;i++)
		{
			currentDayStyle = calendar.dayStyle;
			currentEventStyle = calendar.commonDayStyle;
			
			var mon= "0" +(currentDate.getUTCMonth()+1);
			var dateResult = "0" + currentDate.getUTCDate();
			currentDateString = currentDate.getUTCFullYear() + "/" +(mon).slice(-2) + "/" + dateResult.slice(-2) ;
			
			if (currentDate < calendar.minDate) 
			{
				RenderDayDisabled (calendar, currentDate);
			} 
			else if (currentDate > calendar.maxDate) 
			{
				RenderDayDisabled (calendar, currentDate);
			} 
			else if (currentDate.getUTCMonth() != calendar.calendarDate.getUTCMonth())
			{
				RenderDayDisabled (calendar, currentDate);
			}
			else if (currentDate.getUTCDate() == calendar.calendarDate.getUTCDate())
			{
				if ((currentDate.getUTCDay() == 0) || (currentDate.getUTCDay() == 6))
				{
					if (calendar.allowWeekends == true)
					{
						RenderDayEnabled (calendar, currentDate, calendar.todayDayStyle);
					} 
					else 
					{
						RenderDayDisabled (calendar, currentDate);	
						month = calendar.calendarDate.getUTCMonth();
						calendar.calendarDate.setUTCDate(calendar.calendarDate.getUTCDate()+1);
						if (month != calendar.calendarDate.getUTCMonth())
						{
							renderCalendar(calendar);
						}
						setFieldValue(calendar.attachedId, calendar.calendarDate);
					}
				} else {
					if (calendar.allowWeekdays == true)
					{
						RenderDayEnabled (calendar, currentDate, calendar.todayDayStyle);
					} 
					else 
					{
						RenderDayDisabled (calendar, currentDate);	
						month = calendar.calendarDate.getUTCMonth();
						calendar.calendarDate.setUTCDate(calendar.calendarDate.getUTCDate()+1);
						if (month != calendar.calendarDate.getUTCMonth())
						{
							renderCalendar(calendar);
						}
						setFieldValue(calendar.attachedId, calendar.calendarDate);
					}
				}
			}
			else if ((currentDate.getUTCDay() == 0) || (currentDate.getUTCDay() == 6))
			{
				if (calendar.allowWeekends == true)
				{
				
					style = calendar.holidayDayStyle
					for (j=0; j <calendar.eventDates.length; j++)
					{
						if (calendar.eventDates[j][0] == currentDateString) 
						{
							style = calendar.eventDayStyle;
							RenderDayEvent (calendar, currentDate, style, calendar.eventDates[j][0]);
						}
					}
					
					if (style == calendar.holidayDayStyle)
					{
						RenderDayEnabled (calendar, currentDate, style);
					}
				} 
				else 
				{
					RenderDayDisabled (calendar, currentDate);	
				}
			} else {
				if (calendar.allowWeekdays == true)
				{
					style = calendar.commonDayStyle
					for (j=0; j < calendar.eventDates.length; j++)
					{
						
						if (calendar.eventDates[j][0] == currentDateString) 
						{
							style = calendar.eventDayStyle;
							RenderDayEvent (calendar, currentDate, style, calendar.eventDates[j][0]);
						}
					}

					if (style == calendar.commonDayStyle)
					{
						RenderDayEnabled (calendar, currentDate, style);
					}
				} 
				else 
				{
					RenderDayDisabled (calendar, currentDate);	
				}
			}

			currentDate.setUTCDate(currentDate.getUTCDate() + 1);	
		}
		
		calHtml += ("</tr>");
		

	} while (currentDate.getUTCMonth() == calendar.calendarDate.getUTCMonth());
	return calHtml;
}