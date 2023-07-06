import sys 

if len(sys.argv) < 2:
    print("Erreur : Arguments invalides")
else:
    try:
        params = sys.argv[1]
        params = params.split("--")
        nbr = int(params[0])
        mot = params[1]

        for i in range(int(nbr)):
            print(mot," : ", i+1)

    except ValueError:
        print("Erreur : Le premier paramètre doit être un nombre entier")
