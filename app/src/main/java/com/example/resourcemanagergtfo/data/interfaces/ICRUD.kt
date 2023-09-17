package com.example.resourcemanagergtfo.data.interfaces

interface ICRUD<T,U>: ICreate<T>, IRead<T,U>, IUpdate<T>, IDelete<T>