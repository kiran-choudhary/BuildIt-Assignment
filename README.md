# BuildIt-Assignment-Android
Interview assignment submission to BuildIt @ Wipro digital by Kiran Kumar Choudhary, for the position of Senior Android Engineer.

# Assignment details:
1. Build a native iOS or Android app (your choice).
2. Use the OpenWeatherMap 5 day weather forecast API to retrieve the current 5 day weather forecast.
3. Give some thought to what will make a decent user experience. We would like to see something readable but with no need to go all out on sleek and flashy UI elements.
4. Use any supporting technologies, package management, build systems, component libraries that you are familiar with and feel are appropriate.

# Features implemented:
1. Fetch Weather data from API using city Id.
2. Display forecast data in a list.
3. Catching forecast data in Sharedpreference
4. Fetching new data only after a bufffer period (3 hours in our case).
5. App works offline for buffer period (3 hours) until new data is required.

# App screenshot:
![alt text](https://github.com/kiran-git/BuildIt-Assignment/blob/master/app/ss.png) 


# App architecture
![alt text](https://github.com/kiran-git/BuildIt-Assignment/blob/master/app/Architecture.png) 

# Test envirnment
This code has been tested on Android 9.0.

# Future Improvements
1. Provide an UI where user can select city.
2. Display Wind, Pressure, Rain and Snow data 
3. Save data in Sqlite(its not implemented completely)
4. Fetch timezone details of selected city/country to show relevant timestring in front of forecast date-time.





