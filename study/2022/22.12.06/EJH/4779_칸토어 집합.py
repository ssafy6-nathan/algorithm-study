while True:
    try:
        N = int(input())

        kan = "-"
        for i in range(N):
            kan = kan + " " * (3**i) + kan

        print(kan)

    except EOFError:
        break