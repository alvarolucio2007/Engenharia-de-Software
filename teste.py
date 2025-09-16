def smart_map(*args,**kwargs):
    result=list(args)
    inc=kwargs.get("increment")
    if kwargs.get("order"):
        order=kwargs.get(order)
        for i in range(len(order)):
            if order[i]=="double":
                result=[2*x for x in result]
            elif order[i]=="square":
                result=[x**2 for x in result]
            elif order[i]=="absolute":
                result=[abs(x) for x in result]
            elif order[i]=="increment":
                result=[x+inc for x in result]
    elif kwargs.get("priority")=="reverse":
        if kwargs.get()=="increment":
            result=[x+inc for x in result]
        if kwargs.get()=="absolute":
            result=[abs(x) for x in result]
        if kwargs.get()=="square":
            result=[x**2 for x in result]
        if kwargs.get()=="double":
            result=[2*x for x in result]
    else:
        if kwargs.get()=="double":
            result=[2*x for x in result]
        if kwargs.get()=="square":
            result=[x**2 for x in result]
        if kwargs.get()=="absolute":
            result=[abs(x) for x in result]
        if kwargs.get()=="increment":
            result=[x+inc for x in result]
    return result