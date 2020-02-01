# Jordan weather
This is a sample android app using [WorldWeatherOnline](https://www.worldweatheronline.com/developer/) apis to show current weather in Jordan cities.

I've used the following libraries:

- [Room](https://developer.android.com/topic/libraries/architecture/room)
- [ViewModels](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [DataBinding](https://developer.android.com/topic/libraries/data-binding)
- [Glide](https://github.com/bumptech/glide)
- [Retrofit](https://square.github.io/retrofit/)
- [Dagger 2](https://github.com/google/dagger)

----
## Architecture

This app uses MVVM architecture. There is also a Repository layer, which is for interacting with API calls or DB transactions.

----
## API Key
This project is based on [WorldWeatherOnline](https://www.worldweatheronline.com/developer/) APIs. You can set your own api-key in local.properties and app will use the key everytime app requests network calls to the API.

```local.properties
// local.properties
api-key=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
```



----
## Licence

```
Copyright 2017 Taku Semba.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

