Write-Host "Compiling Java files..." -ForegroundColor Green
javac utils/InputUtils.java tut20.java 

if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilation successful!" -ForegroundColor Green
    Write-Host "Running tut20..." -ForegroundColor Yellow
    java tut20
} else {
    Write-Host "Compilation failed!" -ForegroundColor Red
}
